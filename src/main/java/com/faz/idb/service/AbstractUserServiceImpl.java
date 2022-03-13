/**
 * @author FAZLIU Arber
 * @date 03.03.22
 **/
package com.faz.idb.service;

import com.faz.idb.exceptions.UserAlreadyExistsException;
import com.faz.idb.models.AbstractUser;
import com.faz.idb.models.Account;
import com.faz.idb.models.Customer;
import com.faz.idb.repositories.AbstractUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class AbstractUserServiceImpl<T extends AbstractUser> implements IAbstractUserService<T> {

    @Autowired
    private AbstractUserRepository<T> userRepository;

    @Override
    public T getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user not found"));
    }

    @Override
    public T getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public T saveUser(T user) throws UserAlreadyExistsException {
        if (user.getEmail() == null) {
            throw new BadCredentialsException("Invalid credentials.");
        } else if (getUserByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("An user already exists with this email.");
        }
        return userRepository.save(user);
    }

    @Override
    public List<T> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(T user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.delete(getUserById(id));
    }
}

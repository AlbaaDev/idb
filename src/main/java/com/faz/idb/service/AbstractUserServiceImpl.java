/**
 * @author FAZLIU Arber
 * @date 03.03.22
 **/
package com.faz.idb.service;

import com.faz.idb.exceptions.UserAlreadyExistsException;
import com.faz.idb.models.AbstractUser;
import com.faz.idb.repositories.AbstractUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public abstract class AbstractUserServiceImpl<T extends AbstractUser> implements IAbstractUserService<T> {

    private final AbstractUserRepository<T> abstractRepository;

    @Autowired
    protected AbstractUserServiceImpl(AbstractUserRepository<T> abstractRepository) {
        this.abstractRepository = abstractRepository;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public T getUserById(long id) {
        return abstractRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
    }

    @Override
    public T getUserByEmail(String email) {
        return abstractRepository.findByEmail(email).orElse(null);
    }

    @Override
    public T saveUser(T user) throws UserAlreadyExistsException {
        if (user.getEmail() == null) {
            throw new BadCredentialsException("Invalid credentials.");
        } else if (getUserByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("An user already exists with this email.");
        }
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        T t = abstractRepository.save(user);
        return t;
    }

    @Override
    public List<T> getAllUsers() {
        return abstractRepository.findAll();
    }

    @Override
    public void updateUser(T user) {
        abstractRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        abstractRepository.delete(getUserById(id));
    }

    @Override
    public List<T> getUserByType() {
        List<T> list =  this.abstractRepository.findAll();
        return list;
    }
}

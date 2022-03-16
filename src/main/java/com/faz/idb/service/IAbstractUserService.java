/**
 * @author FAZLIU Arber
 * @date 03.03.22
 **/
package com.faz.idb.service;

import com.faz.idb.exceptions.UserAlreadyExistsException;
import com.faz.idb.models.AbstractUser;
import com.faz.idb.models.Customer;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAbstractUserService<T extends AbstractUser> {
    /**
     * Gets all AbstractUsers.
     *
     * @return the all fileNameToPlural
     */
    List<T> getAllUsers();

    /**
     * Gets account by id.
     *
     * @param id the user id.
     * @return The account found in the database.
     */
    T getUserById(long id);

    /**
     * Gets account by email.
     *
     * @param email the user id.
     * @return The account found in the database.
     */
      T getUserByEmail(String email);

    /**
     * Add an account.
     *
     * @param user the account to be added.
     * @return The added account.
     */
    T saveUser(T user) throws UserAlreadyExistsException;

    /**
     * Update the given user.
     *
     * @param user to be updated.
     */
    void updateUser(T user);

    /**
     * Delete user by id response entity.
     *
     * @param id the user id.
     */
    void deleteUserById(long id);

    List<T> getUserByType();
}

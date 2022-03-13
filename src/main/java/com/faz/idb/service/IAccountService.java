/**
 * @author FAZLIU Arber
 * @date 21.02.22
 **/
package com.faz.idb.service;

import com.faz.idb.dto.AccountDto;

import java.util.List;

public interface IAccountService {
    /**
     * Gets all Accounts.
     *
     * @return the all fileNameToPlural
     */
    List<AccountDto> getAllAccounts();

    /**
     * Gets account by id.
     *
     * @param id the account id.
     * @return The account found in the database.
     */
    AccountDto getAccountById(long id);

    /**
     * Add an account.
     *
     * @param accountDto the account to be added.
     * @return The added account.
     */
    AccountDto addAccount(AccountDto accountDto);

    /**
     * Update the given account.
     *
     * @param account to be updated.
     */
    void updateAccount(AccountDto account);

    /**
     * Delete account by id response entity.
     *
     * @param id the account id.
     */
    void deleteAccountById(long id);
} 

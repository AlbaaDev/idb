/**
 * @author FAZLIU Arber
 * @date 01.03.22
 **/
package com.faz.idb.controllers;

import com.faz.idb.dto.AccountDto;
import com.faz.idb.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    /**
     * Gets account by id.
     *
     * @param id the id
     * @return The account found in the database
     */
    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    /**
     * Gets all Accounts.
     *
     * @return the all fileNameToPlural
     */
    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    /**
     * Add an account.
     *
     * @param accountDto to be added.
     * @return The added account
     */
    @PostMapping("/account")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.addAccount(accountDto), HttpStatus.CREATED);
    }

    /**
     * Update the given account.
     *
     * @param account to be updated.
     */
    @PutMapping("/account")
    public void updateAccount(@RequestBody AccountDto account) {
        accountService.updateAccount(account);
    }

    /**
     * Delete account by id response entity.
     *
     * @param id the id
     */
    @DeleteMapping("/account/{id}")
    public void deleteAccountById(@PathVariable("id") Integer id) {
        accountService.deleteAccountById(id);
    }
}

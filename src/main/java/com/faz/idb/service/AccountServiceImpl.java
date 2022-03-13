/**
 * @author FAZLIU Arber
 * @date 21.02.22
 **/
package com.faz.idb.service;

import com.faz.idb.dto.AccountDto;
import com.faz.idb.mapper.AccountMapper;
import com.faz.idb.models.Account;
import com.faz.idb.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto getAccountById(long id) {
        Account accountFromDb = accountRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Account with id" + id + "not found"));
        return convertAccountEntityToAccountDto(accountFromDb);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return (accountRepository
                .findAll())
                .stream()
                .map(this::convertAccountEntityToAccountDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto addAccount(AccountDto account) {
        return convertAccountEntityToAccountDto(accountRepository.save(convertAccountDtoToAccountEntity(account)));
    }

    @Override
    public void updateAccount(AccountDto accountDto) {
        AccountMapper accountMapper = AccountMapper.INSTANCE;
        accountRepository.save(accountMapper.accountDtoToAccount(accountDto));
    }

    @Override
    public void deleteAccountById(long id) {
        accountRepository.delete(convertAccountDtoToAccountEntity(getAccountById(id)));
    }

    private AccountDto convertAccountEntityToAccountDto(Account account) {
        AccountMapper accountMapper = AccountMapper.INSTANCE;
        return accountMapper.accountToAccountDto(account);
    }

    private Account convertAccountDtoToAccountEntity(AccountDto accountDto) {
        AccountMapper accountMapper = AccountMapper.INSTANCE;
        return accountMapper.accountDtoToAccount(accountDto);
    }
} 

package com.faz.idb.mapper;

import com.faz.idb.dto.AccountDto;
import com.faz.idb.models.Account;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * @author FAZLIU Arber
 * @date 01.03.22
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper .class);

    Account accountDtoToAccount(AccountDto accountDto);

    AccountDto accountToAccountDto(Account account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAccountFromAccountDto(AccountDto accountDto, @MappingTarget Account account);
}

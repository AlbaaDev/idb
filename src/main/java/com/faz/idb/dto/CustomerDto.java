/**
 * @author FAZLIU Arber
 * @date 03.03.22
 **/
package com.faz.idb.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeName("customer")
public class CustomerDto extends AbstractUserDto {
    private PersonDto person;
    private List<AccountDto> accounts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(person, that.person) && Objects.equals(accounts, that.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), person, accounts);
    }
}

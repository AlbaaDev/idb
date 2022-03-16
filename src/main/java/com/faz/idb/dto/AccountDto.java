/**
 * @author FAZLIU Arber
 * @date 01.03.22
 **/
package com.faz.idb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.faz.idb.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long amount;
    private Long identifier;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customer;
}

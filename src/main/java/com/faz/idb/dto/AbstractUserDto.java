/**
 * @author FAZLIU Arber
 * @date 03.03.22
 **/
package com.faz.idb.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "customer", value = CustomerDto.class),
        @JsonSubTypes.Type(name = "adviser", value = AdviserDto.class)
})
public abstract class AbstractUserDto {
    private String email;
    private String password;
}

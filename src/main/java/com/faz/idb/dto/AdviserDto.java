/**
 * @author FAZLIU Arber
 * @date 03.03.22
 **/
package com.faz.idb.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.faz.idb.models.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeName("adivser")
public class AdviserDto extends AbstractUserDto {
    Person person;
}

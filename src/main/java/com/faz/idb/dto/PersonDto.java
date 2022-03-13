/**
 * @author FAZLIU Arber
 * @date 02.03.22
 **/
package com.faz.idb.dto;

import com.faz.idb.enums.Gender;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String firstName;
    private String lastName;
    private Gender gender;
}

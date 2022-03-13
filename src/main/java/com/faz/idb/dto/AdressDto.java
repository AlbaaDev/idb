/**
 * @author FAZLIU Arber
 * @date 02.03.22
 **/
package com.faz.idb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdressDto {
    private String adress;
    private String city;
    private String province;
    private long postCode;
}

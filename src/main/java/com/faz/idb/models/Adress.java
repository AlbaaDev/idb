/**
 * @author FAZLIU Arber
 * @date 07.03.22
 **/
package com.faz.idb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty()
    @Column(name = "street")
    private String street;

    @NotEmpty()
    @Column(name = "city")
    private String city;

    @NotEmpty()
    @Column(name = "province")
    private String province;

    @NotEmpty()
    @Column(name = "postCode")
    private long postCode;
}

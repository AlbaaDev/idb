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
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty()
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotEmpty()
    @Column(name = "email")
    private String email;
}

/**
 * @author FAZLIU Arber
 * @date 02.03.22
 **/
package com.faz.idb.models;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("adviser")
public class Adviser extends AbstractUser {
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Person person;

}

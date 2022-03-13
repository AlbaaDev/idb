/**
 * @author FAZLIU Arber
 * @date 02.03.22
 **/
package com.faz.idb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("customer")
public class Customer extends AbstractUser {

    @OneToOne(mappedBy = "customer", cascade = {CascadeType.ALL}, optional = false)
    @PrimaryKeyJoinColumn
    private Person person;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        this.accounts.add(account);
        account.setCustomer(this);
    }

    public void addPerson(Person person) {
        this.person = person;
        person.setCustomer(this);
    }
}


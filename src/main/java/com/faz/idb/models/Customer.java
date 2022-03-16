/**
 * @author FAZLIU Arber
 * @date 02.03.22
 **/
package com.faz.idb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorOptions;
import org.hibernate.annotations.Where;

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

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        this.accounts.add(account);
        account.setCustomer(this);
    }
}


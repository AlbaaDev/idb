package com.faz.idb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "identifier")
    private Long identifier;

    @Column(name = "amount")
    private Long amount;

    @OneToOne(mappedBy = "account")
    private User user;
}

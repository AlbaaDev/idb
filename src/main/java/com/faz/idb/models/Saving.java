package com.faz.idb.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Saving {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
}

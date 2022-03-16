/**
 * @author FAZLIU Arber
 */
package com.faz.idb.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "identifier")
    private Long identifier;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false , targetEntity = Customer.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Customer customer;
}

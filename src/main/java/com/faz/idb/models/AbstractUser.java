/**
 * @author FAZLIU Arber
 * @date 03.03.22
 **/
package com.faz.idb.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "customer", value = Customer.class),
        @JsonSubTypes.Type(name = "adviser", value = Adviser.class)
})
@DiscriminatorOptions(force = true)
public abstract class AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty()
    @Column(name = "email")
    private String email;

    @NotEmpty()
    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "abstractUser", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, optional = false)
    @PrimaryKeyJoinColumn
    private Person person;

    //TODO
    public Collection<GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
}

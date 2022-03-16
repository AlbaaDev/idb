/**
 * @author FAZLIU Arber
 * @date 02.03.22
 **/
package com.faz.idb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.faz.idb.enums.Gender;
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
public class Person {

    @Id
    @Column(updatable = false)
    private Long id;

    /*
        @NotEmpty()
    */
    private String firstName;

    /*
        @NotEmpty()
    */
    private String lastName;

    /*
        @NotEmpty()
    */
    private Gender gender;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AbstractUser abstractUser;

/*    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Person {

        @Id
        @Column(updatable = false)
        private Long id;

        private String test;

        @MapsId
        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private User user;
    }*/
}

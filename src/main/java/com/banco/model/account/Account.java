package com.banco.model.account;

import com.banco.model.base.BaseModel;
import com.banco.model.person.Person;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Table
@Entity
public class Account extends BaseModel {


    private long agency;

    private String account;

    private AccountType accountType;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "personId")
    private Person person;

}

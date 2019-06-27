package com.banco.model;

import com.banco.model.base.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Getter
@Setter
@EqualsAndHashCode
@Table
@Entity
public class Account extends BaseModel {


    private long agency;

    private String account;

    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

}

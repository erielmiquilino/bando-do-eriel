package com.banco.model;

import com.banco.model.base.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Table
@Entity
public class Person extends BaseModel {


    private String name;

    private String telephone;

    @OneToOne
    @JoinColumn(name = "addressId")
    private Address Address = new Address();

    private int modality;

    private String cpfCnpj;

    private String registration;

    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person", orphanRemoval = true, targetEntity = Account.class)
    private List<Account> accountList = new ArrayList<>();


}

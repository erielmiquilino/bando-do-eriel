package com.banco.model;

import com.banco.model.base.BaseModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person extends BaseModel {

    private String name;
    private String telephone;
    private Address Address = new Address();
    private int modality;
    private String cpfCnpj;
    private String registration;
    private LocalDate date;

    private List<Account> accountList = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public com.banco.model.Address getAddress() {
        return Address;
    }

    public void setAddress(com.banco.model.Address address) {
        Address = address;
    }

    public int getModality() {
        return modality;
    }

    public void setModality(int modality) {
        this.modality = modality;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}

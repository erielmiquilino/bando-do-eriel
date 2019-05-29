package com.banco.model;

import com.banco.model.base.BaseModel;

public class Account extends BaseModel {

    private long agency;
    private String account;
    private AccountType accountType;


    public long getAgency() {
        return agency;
    }

    public void setAgency(long agency) {
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}

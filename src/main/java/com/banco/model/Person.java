package com.banco.model;

public abstract class Person {

    private int id;
    private String name;
    private String telephone;
    private Address Address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}

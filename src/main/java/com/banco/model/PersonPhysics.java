package com.banco.model;

import java.time.LocalDate;

public class PersonPhysics extends Person {

    private String cpf;
    private String generalRegistration;
    private LocalDate dateOfBirth;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGeneralRegistration() {
        return generalRegistration;
    }

    public void setGeneralRegistration(String generalRegistration) {
        this.generalRegistration = generalRegistration;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

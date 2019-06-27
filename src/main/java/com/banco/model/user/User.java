package com.banco.model.user;

import com.banco.model.base.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@Table
@Entity
public class User extends BaseModel {

    private String name;

    private String mail;

    private String password;


}

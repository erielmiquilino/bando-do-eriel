package com.banco.model.user;

import com.banco.model.base.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Table(name = "user")
@Entity
public class User extends BaseModel {

    private String name;

    private String mail;

    private String password;


}

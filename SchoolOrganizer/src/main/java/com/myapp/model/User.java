package com.myapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private long id;
    private String email;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private int phoneNumber;

}

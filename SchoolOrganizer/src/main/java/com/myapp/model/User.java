package com.myapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;


@Getter
@Setter
@ToString
public class User {

    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private List<Role> roles = new ArrayList<>();


}

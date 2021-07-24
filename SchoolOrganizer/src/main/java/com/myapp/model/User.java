package com.myapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

package com.myapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;


@Getter
@Setter
@ToString
public class Role implements GrantedAuthority {

    private long id;
    private String role;


    @Override
    public String getAuthority() {
        return role;
    }

}

package com.myapp.service;

import com.myapp.model.Role;

import java.util.List;

public interface RoleService {

    void setUpDefaultUserRole(Long id);

    List<Role> getRolesByUser(String email);

    Role getRole(String name);
}

package com.myapp.repository;

import com.myapp.model.Role;

import java.util.List;

public interface RoleDao {

    void setUpDefaultRole(Long id);

    List<Role> getRolesByUserEmail(String email);

    Role getRoleByName(String name);

}

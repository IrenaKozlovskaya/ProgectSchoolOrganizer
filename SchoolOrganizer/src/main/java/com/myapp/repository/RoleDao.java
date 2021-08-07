package com.myapp.repository;

import com.myapp.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getRolesByUserEmail(String email);

    Role getRoleByName(String name);

}

package com.myapp.repository.impl;

import com.myapp.model.Role;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoleMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {

        Role role = new Role();
        role.setId(resultSet.getLong("id"));
        role.setRole(resultSet.getString("role"));
        return role;

    }


}

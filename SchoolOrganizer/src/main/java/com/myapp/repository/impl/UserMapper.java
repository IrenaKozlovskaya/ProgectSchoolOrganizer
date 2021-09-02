package com.myapp.repository.impl;

import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<User> {


    private final RoleDaoImpl roleDao;

    @Autowired
    public UserMapper(RoleDaoImpl roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setRoles(roleDao.getRolesByUserEmail(resultSet.getString("email")));
        return user;
    }
}

package com.myapp.repository.impl;

import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.myapp.repository.UserDao;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final String sqlCreateUser = "INSERT INTO users(email, password) values (?, ?)";
    private final String sqlGetAllUsers = "SELECT u.id, u.email, u.password FROM users u ";
    private final String sqlGetUser = sqlGetAllUsers + " WHERE u.email = ?";
    private final String sqlUpdateUser = "UPDATE FROM users (password) value(?) WHERE email = ? ";
    private final String sqlDeleteUser = "DELETE * FROM users u WHERE u.email = ?";

    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;


    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }


    @Override
    public void createUser(User user) {

        jdbcTemplate.update(sqlCreateUser, user.getEmail(), user.getPassword());
    }


    @Override
    public List<User> getAllUsers() {

        return jdbcTemplate.query(sqlGetAllUsers, userMapper);
    }

    @Override
    public User getUser(String email) {

        return jdbcTemplate.query(sqlGetUser, userMapper, email)
                .stream().findAny().orElse(null);
    }

    @Override
    public void updateUser(User user) {

        jdbcTemplate.update(sqlUpdateUser, user.getPassword(), user.getEmail());
    }

    @Override
    public void deleteUser(String email) {

        jdbcTemplate.update(sqlDeleteUser, email);

    }

}

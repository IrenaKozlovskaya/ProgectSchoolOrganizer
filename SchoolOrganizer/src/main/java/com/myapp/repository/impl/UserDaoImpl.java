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
    private final String sqlGetAllUsers = "SELECT * FROM users u LEFT JOIN roles r ON u.role_id = r.id";
    private final String sqlGetUser = sqlGetAllUsers + " WHERE email = ?";
    private final String sqlUpdateUser = "UPDATE FROM users (password) value(?) WHERE email = ? ";
    private final String sqlDeleteUser = "DELETE * FROM users  u WHERE u.email=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createUser(User user) {

        jdbcTemplate.update(sqlCreateUser, user.getEmail(), user.getPassword());
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = jdbcTemplate.query(sqlGetAllUsers, new UserMapper());
        return users;
    }

    @Override
    public User getUser(String email) {
        User user = jdbcTemplate.query(sqlGetUser, new UserMapper(), email)
                .stream().findAny().orElse(null);
        return user;
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

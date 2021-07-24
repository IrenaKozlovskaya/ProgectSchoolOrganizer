package com.myapp.repository.impl;

import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.myapp.repository.UserDao;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createUser(User user) {

        String sql = "INSERT INTO users(email, password) values (?, ?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getPassword());

    }

    @Override
    public User getUser(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        User user = jdbcTemplate.query(sql, new UserMapper(), email)
                .stream().findAny().orElse(null);
        return user;
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users;
    }

    @Override
    public void updateUser(User user) {

        String sql = "UPDATE FROM users (password) value(?) WHERE email = ? ";
        jdbcTemplate.update(sql, user.getPassword(), user.getEmail());

    }

    @Override
    public void deleteUser(String email) {

        String sql = "DELETE * FROM users  u WHERE u.email=?";
        jdbcTemplate.update(sql, email);

    }
}

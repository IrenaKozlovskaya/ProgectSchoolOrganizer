package com.myapp.service;

import com.myapp.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User getUser(String email);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(String login);

}

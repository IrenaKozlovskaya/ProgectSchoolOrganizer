package com.myapp.service.impl;

import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myapp.repository.UserDao;
import com.myapp.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void createUser(User user) {

        try {
            userDao.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public User getUser(String email) {
        try {
            return userDao.getUser(email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateUser(User user) {
        try {
            userDao.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(String login) {

        try {
            userDao.deleteUser(login);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

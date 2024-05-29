package com.adminpanel.adminpanel.service;

import java.util.List;

import com.adminpanel.adminpanel.model.User;

public interface UserService{
    String createUser(User user);
    List<User> readUsers();
    boolean deleteUser(long userId);
    String updateUser(long userId,User User);
    User readUser(long userId);
}
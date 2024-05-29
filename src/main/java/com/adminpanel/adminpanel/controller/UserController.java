package com.adminpanel.adminpanel.controller;

import org.springframework.web.bind.annotation.RestController;

import com.adminpanel.adminpanel.model.User;
import com.adminpanel.adminpanel.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("http://127.0.0.1:5500")
@RestController
public class UserController {
    
    // UserService userService=new UserServiceImpl();
    //Dependency Injection
    @Autowired
    UserService userService;

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.readUsers();
    }

    @GetMapping("users/{userId}")
    public User getUserById(@PathVariable long userId) {
        return userService.readUser(userId);
    }

    @PostMapping("users")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @DeleteMapping("users/{userId}")
    public String deleteUser(@PathVariable long userId){
        if(userService.deleteUser(userId)){
            return "User Deleted Succesfully.";
        }
        return "Not found";
    }
    
    @PutMapping("users/{userId}")
    public String putMethodName(@PathVariable long userId, @RequestBody User user) {
        // System.out.println(user.getUserName());
        return userService.updateUser(userId, user);
    }
}

package com.adminpanel.adminpanel.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminpanel.adminpanel.entity.UserEntity;
import com.adminpanel.adminpanel.model.User;
import com.adminpanel.adminpanel.repository.UserRepository;
import com.adminpanel.adminpanel.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public String createUser(User user) {
        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        // users.add(user);
        return "New User Created Succesfully.";
    }

    @Override
    public List<User> readUsers() {
        List<UserEntity> userList=userRepository.findAll();
        List<User> users=new ArrayList<>();
        for (UserEntity userEntity : userList) {
            User user=new User();
            // BeanUtils.copyProperties(userEntity, users);     //not working .don't know why?
            user.setUserId(userEntity.getUserId());
            user.setEmail(userEntity.getEmail());
            user.setPassword(userEntity.getPassword());
            user.setPhoneNumber(userEntity.getPhoneNumber());
            user.setUserCity(userEntity.getUserCity());
            user.setUserCountry(userEntity.getUserCountry());
            user.setUserName(userEntity.getUserName());
            users.add(user);
        }
        return users;
    }

    @Override
    public boolean deleteUser(long userId) {
        UserEntity userEntity=userRepository.findById(userId).get();
        userRepository.delete(userEntity);
        return true;
    }

    @Override
    public String updateUser(long userId, User user) {
        UserEntity userEntity=userRepository.findById(userId).get();
        
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setUserCity(user.getUserCity());
        userEntity.setUserCountry(user.getUserCountry());
        userEntity.setUserName(user.getUserName());

        userRepository.save(userEntity);
        return "Updated Succesfully.";
    }

    @Override
    public User readUser(long userId) {
        UserEntity userEntity=userRepository.findById(userId).get();
        User user=new User();
        BeanUtils.copyProperties(userEntity, user);

        return user;
    }
    
}

package com.backend.spring.service;

import java.util.List;

import com.backend.spring.model.User;

public interface UserService {

    void saveUser(User user);
    
    List<User> findAllUsers();
     
    void deleteUserById(int id);
     
    User findById(int id);
     
    void updateUser(User user);
    
    void deleteAllUsers();
    
}

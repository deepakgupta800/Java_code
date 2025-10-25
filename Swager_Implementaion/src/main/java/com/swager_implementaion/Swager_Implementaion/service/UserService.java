package com.swager_implementaion.Swager_Implementaion.service;

import com.swager_implementaion.Swager_Implementaion.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    List<User> getUserById(Long id);
}

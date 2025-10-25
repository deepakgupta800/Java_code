package com.swager_implementaion.Swager_Implementaion.controller;

import com.swager_implementaion.Swager_Implementaion.api.DefaultApi;
import com.swager_implementaion.Swager_Implementaion.model.User;
import com.swager_implementaion.Swager_Implementaion.model.User2Dto;
import com.swager_implementaion.Swager_Implementaion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements DefaultApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<User2Dto> saveUser(User user) {
        User saved = userService.saveUser(user);
        return ResponseEntity.ok(new User2Dto()
                .id(saved.getId())
                .name(saved.getName()));
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @Override
    public ResponseEntity<List<User>> getUserById(Long id) {
        List<User> users = userService.getUserById(id);
        return ResponseEntity.ok(users);
    }
}
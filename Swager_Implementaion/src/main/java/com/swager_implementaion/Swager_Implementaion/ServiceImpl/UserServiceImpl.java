package com.swager_implementaion.Swager_Implementaion.service.impl;

import com.swager_implementaion.Swager_Implementaion.entity.UserEntity;
import com.swager_implementaion.Swager_Implementaion.mapper.UserMapper;
import com.swager_implementaion.Swager_Implementaion.model.User;
import com.swager_implementaion.Swager_Implementaion.repository.UserRepository;
import com.swager_implementaion.Swager_Implementaion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity saved = userRepository.save(entity);
        return UserMapper.toDto(saved);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getUserById(Long id) {
        return userRepository.findById(id)
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
}

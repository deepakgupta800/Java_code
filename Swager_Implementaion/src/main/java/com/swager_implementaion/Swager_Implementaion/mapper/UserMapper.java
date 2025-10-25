package com.swager_implementaion.Swager_Implementaion.mapper;

import com.swager_implementaion.Swager_Implementaion.entity.UserEntity;
import com.swager_implementaion.Swager_Implementaion.model.User;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User toDto(UserEntity entity) {
        return new User()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail());
    }
}









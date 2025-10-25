package com.swager_implementaion.Swager_Implementaion.repository;

import com.swager_implementaion.Swager_Implementaion.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

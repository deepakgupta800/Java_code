package com.swager_implementaion.Swager_Implementaion.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "swagger_impl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
}


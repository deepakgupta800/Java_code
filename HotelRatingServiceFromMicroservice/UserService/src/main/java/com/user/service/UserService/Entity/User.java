package com.user.service.UserService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro-users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column(name= "ID")
    private String userId;

    @Column(name= "Name")
    private String name;

    @Column(name= "Email")
    private String email;

    @Column(name= "About ")
    private String about;

    public User(String email, String name, String about, String userId) {
        this.email = email;
        this.name = name;
        this.about = about;
        this.userId = userId;
    }


    @Transient
    List<Rating> ratings = new ArrayList<>();

}

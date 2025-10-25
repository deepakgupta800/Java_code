package com.user.service.UserService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    private String OrderId;
    private String snacks;
    private String mainCourse;
    private String drinks;

}

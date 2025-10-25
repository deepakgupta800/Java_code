package com.FoodOrderService.OrderService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Food_Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    private String orderId;
    private String userId;
    private String snacks;
    private String mainCourse;
    private String drinks;

}

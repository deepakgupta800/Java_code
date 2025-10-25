package com.FoodOrderService.OrderService.repository;

import com.FoodOrderService.OrderService.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {

    OrderEntity findByUserId(String userid);
}

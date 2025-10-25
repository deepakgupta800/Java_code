package com.FoodOrderService.OrderService.service;


import com.FoodOrderService.OrderService.entity.OrderEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    OrderEntity createOrder(OrderEntity orderEntity);


    OrderEntity getOrderByUserId(String userId);


    OrderEntity deleteOrderByOrderId(String orderId);

}

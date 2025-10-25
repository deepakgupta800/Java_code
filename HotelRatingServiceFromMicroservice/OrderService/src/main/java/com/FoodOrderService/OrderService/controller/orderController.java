package com.FoodOrderService.OrderService.controller;

import com.FoodOrderService.OrderService.entity.OrderEntity;
import com.FoodOrderService.OrderService.serviceImpl.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class orderController {

    private final OrderServiceImpl orderService;

    public orderController(OrderServiceImpl orderService){
        this.orderService = orderService;
    }

    @PostMapping
   public ResponseEntity<OrderEntity> saveYourOrder(@RequestBody OrderEntity orderEntity){
        OrderEntity orderEntity1 = orderService.createOrder(orderEntity);
        return new ResponseEntity<>(orderEntity1, HttpStatus.CREATED);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<OrderEntity> findOrderByUserId(@PathVariable String userId){
        OrderEntity orderEntities = orderService.getOrderByUserId(userId);
        return new ResponseEntity<>(orderEntities, HttpStatus.OK);
    }


}

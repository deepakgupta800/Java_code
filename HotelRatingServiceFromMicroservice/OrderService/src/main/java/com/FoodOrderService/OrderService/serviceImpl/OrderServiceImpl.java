package com.FoodOrderService.OrderService.serviceImpl;

import com.FoodOrderService.OrderService.entity.OrderEntity;
import com.FoodOrderService.OrderService.repository.OrderRepository;
import com.FoodOrderService.OrderService.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {

        OrderEntity orderEntity1 = orderRepository.save(orderEntity);
        return orderEntity1;

    }

    @Override
    public OrderEntity getOrderByUserId(String userId) {
       return orderRepository.findByUserId(userId);

    }

    @Override
    public OrderEntity deleteOrderByOrderId(String orderId) {
        return null;
    }
}

package com.user.service.UserService.external;

import com.user.service.UserService.Entity.Hotel;
import com.user.service.UserService.Entity.OrderEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORDERSERVICE")
public interface OrderService {

    @GetMapping("/order/{userId}")
    OrderEntity getFoodOrder(@PathVariable String userId);

}

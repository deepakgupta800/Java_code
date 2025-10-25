package com.user.service.UserService.external;

import com.user.service.UserService.Entity.Hotel;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/Hotel/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}

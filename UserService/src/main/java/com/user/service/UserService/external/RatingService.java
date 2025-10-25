package com.user.service.UserService.external;

import com.user.service.UserService.Entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
    @GetMapping("/ratings/users/{userid}")
    List<Rating> getRatingsByUserId(@PathVariable String userid);
}

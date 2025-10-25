package com.user.service.UserService.Controller;

import com.user.service.UserService.Entity.User;
import com.user.service.UserService.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    // crate
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
       return  new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/{userID}")
//    @CircuitBreaker(name="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @Retry(name="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> GetSingleuser(@PathVariable String userID){

        User user = userService.getUserById(userID);
        return new ResponseEntity<>(user,HttpStatus.FOUND);

    }

//     create fallback methode for circuitbreaker

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
        log.info("Fallback is executed because service is down", ex.getMessage());
     User user  = User.builder()
                .email("dummy@gmail.com")
                .name("Xyz")
                .about("service is down")
                .build();
        return new ResponseEntity<>(user ,HttpStatus.OK);

    }

    @GetMapping
    @RateLimiter(name = "ratingHotelService", fallbackMethod = "fallbackMethod")
    public ResponseEntity<List<User>> GetAllUsers(){

        List<User> users = userService.getUser();
        return new ResponseEntity<>(users,HttpStatus.OK);

    }
    //     create fallback methode for circuitbreaker

    public ResponseEntity<List<User>> fallbackMethod(Exception ex){
        log.info("Fallback is executed because service is down", ex.getMessage());
        User user;
        List<User> user1 = new ArrayList<>();
        user1.add(new User("dummy@gmail.com", "Xyz" , "service is down","dsfgds"));
        return new ResponseEntity<>(user1 ,HttpStatus.OK);

    }

}

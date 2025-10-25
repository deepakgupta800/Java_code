package com.user.service.UserService.impl;

import com.user.service.UserService.Entity.Hotel;
import com.user.service.UserService.Entity.OrderEntity;
import com.user.service.UserService.Entity.Rating;
import com.user.service.UserService.Entity.User;
import com.user.service.UserService.Exception.ResourceNotFoundException;
import com.user.service.UserService.external.HotelService;
import com.user.service.UserService.external.OrderService;
import com.user.service.UserService.external.RatingService;
import com.user.service.UserService.file.CreateExcelFile;
import com.user.service.UserService.repository.UserRepository;
import com.user.service.UserService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CreateExcelFile createExcelFile;

    @Override
    public User saveUser(User user) {

        String str = UUID.randomUUID().toString();
        user.setUserId(str);
        return userRepository.save(user);

    }

    @Override
    public List<User> getUser() {

            List<User> user = userRepository.findAll();
            createExcelFile.createExcel(user);
            List<String> list = user.stream().map(x->x.getUserId()).toList();

        for (int i=0; i< user.size(); i++){
            User user1 = user.get(i);
            List<Rating> ratings = ratingService.getRatingsByUserId(user1.getUserId());
            List<Rating> ratingslist = ratings.stream().map(rating -> {
                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                OrderEntity orderEntity = orderService.getFoodOrder(user1.getUserId());
                hotel.setOrderEntity(orderEntity);
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());
            user1.setRatings(ratings);
        }

            return user;

    }

    @Override
    public User getUserById(String id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with given ID not found: " + id));

      Rating [] ratingOfUsers  =  restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+ user.getUserId(),Rating [].class);
     log.info("{}",ratingOfUsers);

        Arrays.stream(ratingOfUsers).collect(Collectors.toList()).forEach(System.out::println);

     List<Rating> ratings = Arrays.stream(ratingOfUsers).toList();

     List<Rating> ratingList = ratings.stream().map(rating -> {

//       ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/Hotel/"+rating.getHotelId(), Hotel.class);
         Hotel hotel = hotelService.getHotel(rating.getHotelId());
         rating.setHotel(hotel);
         return rating;

     }).collect(Collectors.toList());

     user.setRatings(ratingList);
    return user;
    }
}
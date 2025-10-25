package com.Rating.service.RatingService.Controller;

import com.Rating.service.RatingService.entity.Rating;
import com.Rating.service.RatingService.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingServiceImpl ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){

        Rating rating1 =ratingService.createRating(rating);
        return  new ResponseEntity<>(rating1, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){

        List<Rating> rating1 =ratingService.getRatings();
        return  new ResponseEntity<>(rating1, HttpStatus.FOUND);

    }

    @GetMapping("/users/{userid}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userid){

        List<Rating> rating1 =ratingService.getRatingByUserId(userid);
        return new ResponseEntity<>(rating1, HttpStatus.OK);

    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){

        List<Rating> rating1 =ratingService.getRatingByHotelId(hotelId);
        return  new ResponseEntity<>(rating1, HttpStatus.FOUND);

    }

}

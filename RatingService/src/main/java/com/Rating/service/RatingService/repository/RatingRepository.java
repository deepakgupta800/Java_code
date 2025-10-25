package com.Rating.service.RatingService.repository;

import com.Rating.service.RatingService.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    List<Rating> findByUserId(String userid);
    List<Rating> findByHotelId(String hotelId);

}

package com.Rating.service.RatingService.impl;

import com.Rating.service.RatingService.entity.Rating;
import com.Rating.service.RatingService.repository.RatingRepository;
import com.Rating.service.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public Rating createRating(Rating rating) {

        String id = UUID.randomUUID().toString();
        rating.setRatingId(id);
      return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
       return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String HotelId) {
        return ratingRepository.findByHotelId(HotelId);
    }
}

package com.user.service.UserService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private String ratingId;
    private String UserId;
    private String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;

}

package com.Hotel.service.HotelService.service;

import com.Hotel.service.HotelService.Entity.Hotel;

import java.util.List;

public interface HotelServices {

    Hotel Create(Hotel hotel);

    Hotel getHotelById(String id);

    List<Hotel> getHotel();


}

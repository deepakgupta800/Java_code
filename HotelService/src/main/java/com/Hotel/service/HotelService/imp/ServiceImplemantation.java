package com.Hotel.service.HotelService.imp;

import com.Hotel.service.HotelService.Entity.Hotel;
import com.Hotel.service.HotelService.exceptions.ResourceNotFoundExceptions;
import com.Hotel.service.HotelService.repository.HotelRepository;
import com.Hotel.service.HotelService.service.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceImplemantation implements HotelServices {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel Create(Hotel hotel) {

        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepository.save(hotel);

    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Hotel not found with id: " + id));
    }
    @Override
    public List<Hotel> getHotel() {

        return hotelRepository.findAll();

    }
}

package com.Hotel.service.HotelService.Controller;

import com.Hotel.service.HotelService.Entity.Hotel;
import com.Hotel.service.HotelService.imp.ServiceImplemantation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Hotel")
public class HotelController {

    @Autowired
    ServiceImplemantation serviceImplemantation;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = serviceImplemantation.Create(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }


    @GetMapping("/{HotelId}")
    public ResponseEntity<Hotel> getById(@PathVariable String HotelId){
       Hotel hotel1 = serviceImplemantation.getHotelById(HotelId);
        return new ResponseEntity<>(hotel1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotel1 = serviceImplemantation.getHotel();
        return new ResponseEntity<>(hotel1, HttpStatus.OK);
    }


}

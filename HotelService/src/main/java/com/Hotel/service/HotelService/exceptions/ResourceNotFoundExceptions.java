package com.Hotel.service.HotelService.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException{

public ResourceNotFoundExceptions (){
    super("Resource not found Exception");
}


    public ResourceNotFoundExceptions (String message){
        super(message);
    }


}

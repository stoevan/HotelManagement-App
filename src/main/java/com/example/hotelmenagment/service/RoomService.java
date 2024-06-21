package com.example.hotelmenagment.service;

import com.example.hotelmenagment.models.Hotel;
import com.example.hotelmenagment.models.Room;

import java.util.List;

public interface RoomService {
    List<Room> listAll();
    Room findById(Long id);
    Room save(Integer room_num, Boolean available, Double price_PreNight, Integer capacity, Long hotelId);
    Room save(Integer room_num, Boolean available, Double price_PreNight, Integer capacity);
    Room edit(Long id,Integer room_num, Boolean available, Double price_PreNight, Integer capacity, Long hotelId);

    void delete(Long id);

    List<Room> getRoomByHotelId(Long hotelId);
}

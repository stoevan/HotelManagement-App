package com.example.hotelmenagment.service;

import com.example.hotelmenagment.models.Hotel;
import com.example.hotelmenagment.models.Room;

import java.util.List;

public interface HotelService {
    List<Hotel> listAll();
    Hotel findById(Long id);
    Hotel save(String name, String address, String city);
    Hotel edit(Long id,String name, String address, String city);
    void delete(Long id);
    List<Hotel> findByCity(String city);

}

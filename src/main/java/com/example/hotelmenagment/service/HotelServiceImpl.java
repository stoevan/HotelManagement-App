package com.example.hotelmenagment.service;

import com.example.hotelmenagment.models.Exceptions.InvalidHotelIdException;
import com.example.hotelmenagment.models.Hotel;
import com.example.hotelmenagment.models.Room;
import com.example.hotelmenagment.repository.HotelRepository;
import com.example.hotelmenagment.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
        private final RoomRepository roomRepository;

    public HotelServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Hotel> listAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElseThrow(InvalidHotelIdException::new);
    }

    @Override
    public Hotel save(String name, String address, String city) {

        Hotel hotel= new Hotel(name,address,city);
        hotelRepository.save(hotel);
        return hotel;


    }

    @Override
    public Hotel edit(Long id, String name, String address, String city) {
        Hotel hotel=hotelRepository.findById(id).orElseThrow(InvalidHotelIdException::new);

        if(!hotel.getName().equals(name))
            hotel.setName(name);
        if(!hotel.getAddress().equals(address))
            hotel.setAddress(address);
        if(!hotel.getCity().equals(city))
            hotel.setCity(city);

        hotelRepository.save(hotel);
        return  hotel;

    }

    @Override
    public void delete(Long id) {
        Hotel hotel=hotelRepository.findById(id).orElseThrow(InvalidHotelIdException::new);
        hotelRepository.delete(hotel);

    }

    @Override
    public List<Hotel> findByCity(String city) {
        return this.hotelRepository.findByCity(city);
    }


}

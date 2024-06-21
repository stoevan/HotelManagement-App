package com.example.hotelmenagment.service;

import com.example.hotelmenagment.models.Exceptions.InvalidHotelIdException;
import com.example.hotelmenagment.models.Exceptions.InvalidRoomIdException;
import com.example.hotelmenagment.models.Hotel;
import com.example.hotelmenagment.models.Room;
import com.example.hotelmenagment.repository.HotelRepository;
import com.example.hotelmenagment.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {
    private final RoomRepository roomRepository;
    private  final HotelRepository hotelRepository;

    public RoomServiceImp(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Room> listAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow(InvalidRoomIdException::new);
    }

    @Override
    public Room save(Integer room_num, Boolean available, Double price_PreNight, Integer capacity, Long hotelId) {
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(InvalidHotelIdException::new);
        Room room=new Room(room_num,available,price_PreNight,capacity,hotel);
        roomRepository.save(room);
        return room;
    }

    @Override
    public Room save(Integer room_num, Boolean available, Double price_PreNight, Integer capacity) {
        Room room=new Room(room_num,available,price_PreNight,capacity);
        roomRepository.save(room);
        return room;
    }

    @Override
    public Room edit(Long id, Integer room_num, Boolean available, Double price_PreNight, Integer capacity, Long hotelId) {
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(InvalidHotelIdException::new);
        Room room=roomRepository.findById(id).orElseThrow(InvalidRoomIdException::new);
        if(room.getRoom_num()!=room_num)
            room.setRoom_num(room_num);
        if(room.getAvailable()!=available)
            room.setAvailable(available);
        if(room.getPrice_PerNight()!=price_PreNight)
            room.setPrice_PerNight(price_PreNight);
        if(room.getCapacity()!=capacity)
            room.setCapacity(capacity);
        if(room.getHotel()!=hotel)
            room.setHotel(hotel);

        roomRepository.save(room);
        return room;

    }

    @Override
    public void delete(Long id) {
        Room room=roomRepository.findById(id).orElseThrow(InvalidRoomIdException::new);
        roomRepository.delete(room);
    }

    @Override
    public List<Room> getRoomByHotelId(Long hotelId) {
        return roomRepository.findRoomByHotelId(hotelId);
    }
}

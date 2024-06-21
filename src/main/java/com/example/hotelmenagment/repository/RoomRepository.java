package com.example.hotelmenagment.repository;

import com.example.hotelmenagment.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findRoomByHotelId(Long hotelId);
 }

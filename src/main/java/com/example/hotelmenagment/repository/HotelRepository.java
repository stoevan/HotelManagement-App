package com.example.hotelmenagment.repository;

import com.example.hotelmenagment.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
            List<Hotel> findByCity(String city);

}

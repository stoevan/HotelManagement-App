package com.example.hotelmenagment.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer room_num;
    private Boolean available;
    private Double price_PerNight;
    private Integer capacity;
    @ManyToOne(fetch = FetchType.EAGER)
    private Hotel hotel;

    public Room( Integer room_num, Boolean available, Double price_PerNight, Integer capacity, Hotel hotel) {

        this.room_num = room_num;
        this.available = available;
        this.price_PerNight = price_PerNight;
        this.capacity = capacity;
        this.hotel = hotel;
    }

    public Room( Integer room_num, Boolean available, Double price_PerNight, Integer capacity) {

        this.room_num = room_num;
        this.available = available;
        this.price_PerNight = price_PerNight;
        this.capacity = capacity;

    }

    public Room(){}
}

package com.example.hotelmenagment.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    public Hotel(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;

    }
    public Hotel(){}
}

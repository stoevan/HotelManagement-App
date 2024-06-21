package com.example.hotelmenagment.controller;

import com.example.hotelmenagment.models.Hotel;
import com.example.hotelmenagment.models.Room;
import com.example.hotelmenagment.service.HotelService;
import com.example.hotelmenagment.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels/")
public class HotelControler {
    private final HotelService hotelsService;
    private final RoomService roomService;

    public HotelControler(HotelService hotelsService, RoomService roomService) {
        this.hotelsService = hotelsService;
        this.roomService = roomService;
    }

    @GetMapping()
    public String GetAllHotels(@RequestParam(required = false) String nameSearch,Model model)
    {
        List<Hotel> hotels;
        if (nameSearch == null ) {
            hotels = this.hotelsService.listAll();
        } else {
            hotels = this.hotelsService.findByCity(nameSearch);
        }

        model.addAttribute("hotel",hotels);
        return "listHotels";
    }

    @GetMapping("add")
    public String ShowAdd(Model model)
    {

        return "Hotelform";
    }



    @GetMapping("/rooms/{id}")
    public String showHotelRooms(Model model, @PathVariable Long id) {
        List<Room> roomList = roomService.getRoomByHotelId(id);
        model.addAttribute("roomList", roomList);
        model.addAttribute("hotelId", id);

        return "hotel-room-list";
    }


    @PostMapping()
    public String AddHotel(@RequestParam String name,
                          @RequestParam String address,
                          @RequestParam String city )
    {
        hotelsService.save(name, address, city);
        return "redirect:/hotels/";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable Long id, Model model)
    {
        model.addAttribute("hotel",hotelsService.findById(id));
       model.addAttribute("rooms",roomService.listAll());
        return "Hotelform";
    }
    @PostMapping("{id}")
    public String EditHotel(@PathVariable Long id,
                          @RequestParam String name,
                          @RequestParam String address,
                          @RequestParam String city
                         )
    {
        hotelsService.edit(id,name,address,city);
        return "redirect:/hotels/";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable Long id) {
        this.hotelsService.delete(id);
        return "redirect:/hotels/";
    }





}

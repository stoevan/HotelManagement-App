package com.example.hotelmenagment.controller;

import com.example.hotelmenagment.service.HotelService;
import com.example.hotelmenagment.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms/")
public class RoomController {
    private final RoomService roomService;
    private final HotelService hotelService;

    public RoomController(RoomService roomService, HotelService hotelService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
    }

    @GetMapping()
    public String ListAllRooms(Model model)
    {
        model.addAttribute("rooms",roomService.listAll());

        return "listRooms";
    }

    @GetMapping("add")
    public String ShowAdd(Model model)
    {

        model.addAttribute("hotel",hotelService.listAll());
        return "form";
    }

    @PostMapping()
    public String AddRoom(@RequestParam Integer room_num,
                          @RequestParam Boolean available,
                          @RequestParam Double price_per_night,
                          @RequestParam Integer capacity,
                          @RequestParam Long hotel)
    {
     roomService.save(room_num,available,price_per_night,capacity,hotel);
     return "redirect:/rooms/";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable Long id, Model model)
    {
        model.addAttribute("room",roomService.findById(id));
        model.addAttribute("hotel",hotelService.listAll());
        return "form";
    }
    @PostMapping("{id}")
    public String AddRoom(@PathVariable Long id,
                          @RequestParam Integer room_num,
                          @RequestParam Boolean available,
                          @RequestParam Double price_per_night,
                          @RequestParam Integer capacity,
                          @RequestParam Long hotel)
    {
        roomService.edit(id,room_num,available,price_per_night,capacity,hotel);
        return "redirect:/rooms/";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable Long id) {
        this.roomService.delete(id);
        return "redirect:/rooms/";
    }

}

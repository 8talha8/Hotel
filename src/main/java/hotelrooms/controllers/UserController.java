package hotelrooms.controllers;


import hotelrooms.models.Booking;
import hotelrooms.models.Room;
import hotelrooms.service.UserRoomService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

@RestController
public class UserController {



    @Autowired
    UserRoomService userRoom;




    
    @RequestMapping(value = "/rooms/free/between/", method = RequestMethod.GET)
    @ResponseBody
    public List<Room> getAvailableRoomsBetweenDates(@RequestParam("from") String arrivalS, @RequestParam("to") String departureS) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm");

        LocalDateTime arrival = LocalDateTime.parse(arrivalS, formatter);
        LocalDateTime departure = LocalDateTime.parse(departureS, formatter);
        List<Room> retList = userRoom.findByBookFromIsBetween(arrivalS, departureS);

        return retList;
    }


    
    @RequestMapping(value = "/rooms/reservation", method = RequestMethod.PUT)
    public List<Booking> reserveRoom(@RequestBody List<Booking> bookings){


        return userRoom.reserveRoom(bookings);

    }







}

package hotelrooms.controllers;

import hotelrooms.models.Room;
import hotelrooms.service.RoomsAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class AdminController {



    @Autowired
    RoomsAdminService roomsAdminService;



    
    @RequestMapping(method = RequestMethod.GET, value = "/api/admin/allrooms")
    @ResponseBody
    public Iterable<Room> rooms() {
        return roomsAdminService.showAllRooms();
    }





    
    @RequestMapping(method = RequestMethod.GET, value = "/api/admin/room/name/{name}")
    public Room findRoomByName(@PathVariable String name) {

        return roomsAdminService.findRoomByName(name);
    }


    
    @RequestMapping(method = RequestMethod.POST, value = "/api/admin/room/create")

    public Room save(@RequestBody Room room) {
        return roomsAdminService.createRoom(room);
    }


    
    @GetMapping( value = "/api/admin/room/{id}")
    public Optional<Room> show(@PathVariable String id) {
        return roomsAdminService.showRoomById(id);
    }




    
    @RequestMapping(method = RequestMethod.PUT, value = "/api/admin/room/update/{id}")
    public Room update(@PathVariable String id, @RequestBody Room room) {

        return roomsAdminService.update(id, room);

    }


    
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/admin/room/{id}")
    public String delete(@PathVariable String id) {
        roomsAdminService.delete(id);
        return "deleted";

    }



}

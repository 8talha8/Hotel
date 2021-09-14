package hotelrooms.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelrooms.models.Room;
import hotelrooms.repositories.RoomsAdminRepository;
import hotelrooms.service.RoomsAdminService;

@Service

public class RoomsAdminImpl implements RoomsAdminService {



    @Autowired
    RoomsAdminRepository roomsAdminRepository;


    @Override
    public Iterable<Room> showAllRooms() {
        return roomsAdminRepository.findAll();

    }

    @Override
    public Room findRoomByName(String name) {

        Room room = roomsAdminRepository.findRoomByNameEquals(name);

        return room;


    }


    @Override
    public Room createRoom(Room room) {
        roomsAdminRepository.save(room);
        return room;
    }

    @Override
    public Optional<Room> showRoomById(String id) {
        return roomsAdminRepository.findById(id);
    }

    @Override
    public Room update(String id, Room room) {
        Optional<Room> optRoom = roomsAdminRepository.findById(id);
        Room r = optRoom.get();
        if (r.getName() != null) {
            r.setName(room.getName());
        }
        if (r.getPrice() > 0){
            r.setPrice(room.getPrice());
        }
        if (r.getBeds() != 0) {
            r.setBeds(room.getBeds());
        }


        roomsAdminRepository.save(r);
        return r;
    }

    @Override
    public String delete(String id) {
        Optional<Room> optionalRoom = roomsAdminRepository.findById(id);
        Room room = optionalRoom.get();
        roomsAdminRepository.delete(room);

        return "";
    }


}

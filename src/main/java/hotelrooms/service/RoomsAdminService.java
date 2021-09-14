package hotelrooms.service;

import java.util.Optional;

import hotelrooms.models.Room;

public interface RoomsAdminService {

    Iterable<Room> showAllRooms();

    Room findRoomByName(String name);

    Room createRoom(Room room);

    Optional<Room> showRoomById(String id);

    Room update(String id, Room room);

    String delete(String id);

}

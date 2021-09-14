package hotelrooms.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hotelrooms.models.Room;

import java.util.Optional;

public interface RoomsAdminRepository extends CrudRepository<Room, String> {



    @Override
    void delete(Room room);




    @Query("{'name' : ?0}}")
    Room findRoomByNameEquals(String name);

    Optional<Room> findRoomByName(String name);


}

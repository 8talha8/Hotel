package hotelrooms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import hotelrooms.models.Room;


@RepositoryRestResource
public interface RoomsRepository extends CrudRepository<Room, String> {





}

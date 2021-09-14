package hotelrooms.service;


import java.util.List;

import hotelrooms.models.Booking;
import hotelrooms.models.Room;

public interface UserRoomService {


    List<Room> findByBookFromIsBetween(String arrivalS, String departureS);

    List<Booking> reserveRoom(List<Booking> bookings);
    Booking save(Booking reservedRoom);


}

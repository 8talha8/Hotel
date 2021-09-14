package hotelrooms.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelrooms.models.Booking;
import hotelrooms.models.Room;
import hotelrooms.repositories.ReserveRepository;
import hotelrooms.repositories.RoomsRepository;
import hotelrooms.service.UserRoomService;


@Service
public class UserRoomImpl implements UserRoomService {

    @Autowired
    RoomsRepository roomsRepository;
//
    @Autowired
    ReserveRepository reserveRepository;

    public UserRoomImpl() {
    }

    //search of all available rooms
    @Override
    public List<Room> findByBookFromIsBetween(String arrivalS, String departureS) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm");

        LocalDateTime arrival = LocalDateTime.parse(arrivalS, formatter);
        LocalDateTime departure = LocalDateTime.parse(departureS, formatter);

        List<Booking> reservedRoomsListF = (ArrayList<Booking>) reserveRepository.findByBookFromIsBetween(arrival, departure);
        List<Booking> reservedRoomsB = (ArrayList<Booking>) reserveRepository.findByBookingBetween(arrival,departure);
        List<Booking> reservedRoomsC = (ArrayList<Booking>) reserveRepository.findByBookingAfter(arrival,departure);

        List<Booking> reservedRoomsList = new ArrayList<>();

        reservedRoomsList.addAll(reservedRoomsListF);
        reservedRoomsList.addAll(reservedRoomsB);
        reservedRoomsList.addAll(reservedRoomsC);



        if (reservedRoomsList != null && reservedRoomsList.size() > 0) {

            List<Room> freeRooms = (ArrayList<Room>) roomsRepository.findAll();

            for (Booking reservedRoom: reservedRoomsList){
                for (Room room: freeRooms){
                    if (room.getId().equals(reservedRoom.getRoomId())){
                        freeRooms.remove(room);
                        break;
                    }
                }
            }

            return freeRooms;

        }
        else{
            Iterable<Room> allRooms = roomsRepository.findAll();

            List<Room> freeRooms = new ArrayList<>();

            for (Room room : allRooms) {
                freeRooms.add(room);

            }
            return freeRooms;
        }
    }

    @Override
    public List<Booking> reserveRoom(List<Booking> bookings) {
    	List<Booking> bookingsRes= new ArrayList();
    	bookings.stream().forEach(booking->{
        String arrivalF =  booking.getDates().getBookFrom() + " 00:01";
        String departureF = booking.getDates().getBookTo() + " 00:01";

       


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime arrival = LocalDateTime.parse(arrivalF, formatter);
        LocalDateTime departure = LocalDateTime.parse(departureF, formatter);
        Booking reservedRoom = new Booking(booking.getRoomId(),booking.getUserId(),arrival,departure);

        if (reservedRoom.getDates().getBookFrom() != null && reservedRoom.getDates().getBookTo() !=null && reservedRoom.getDates().getBookFrom().isBefore(reservedRoom.getDates().getBookTo())){
        	bookingsRes.add( reserveRepository.save(reservedRoom));
        }

      throw new RuntimeException ("Failed");
    	});
    	return bookingsRes;
    }

    @Override
    public Booking save(Booking reservedRoom){


        return  reserveRepository.save(reservedRoom);
    }


}

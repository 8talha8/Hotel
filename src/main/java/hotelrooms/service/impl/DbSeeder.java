package hotelrooms.service.impl;

import hotelrooms.models.Booking;
import hotelrooms.models.Room;
import hotelrooms.repositories.ReserveRepository;
import hotelrooms.repositories.RoomsRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private RoomsRepository roomsRepository;
    private ReserveRepository reserveRepository;


    public DbSeeder(RoomsRepository roomsRepository, ReserveRepository reserveRepository) {
        this.roomsRepository = roomsRepository;
        this.reserveRepository = reserveRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Room room = new Room("1","101",2, Double.parseDouble("50"));
        Room room2 = new Room("2","102",2, Double.parseDouble("45.5"));
        Room room3 = new Room("3","103",3, Double.parseDouble("150"));
        Room room4 = new Room("4","104",3, Double.parseDouble("160"));
        Room room5 = new Room("5","penthouse",4, Double.parseDouble("1150"));


        Booking rv1= new Booking("2","5d10e084626c500ae89b66c9", LocalDateTime.of(2019, 7, 6, 14,0), LocalDateTime.of(2019, 7, 8, 12,0));
        Booking rv2= new Booking("3", "5d10e04f626c500ae89b66c8", LocalDateTime.of(2019, 7, 7, 14,0), LocalDateTime.of(2019, 7, 12, 12,0));





        this.roomsRepository.deleteAll();
        this.reserveRepository.deleteAll();




        List<Room> rooms = Arrays.asList(room,room2,room3,room4,room5);
        List<Booking> rvl = Arrays.asList(rv1,rv2);
        this.reserveRepository.saveAll(rvl);
        this.roomsRepository.saveAll(rooms);
    }


}

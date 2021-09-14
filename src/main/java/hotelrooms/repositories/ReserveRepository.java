package hotelrooms.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hotelrooms.models.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReserveRepository extends CrudRepository<Booking, String> {



    @Query("{ 'dates.bookFrom' : { $lt : ?0}, 'dates.bookTo' : { $gt : ?0}}}" )
    Iterable<Booking> findByBookFromIsBetween(LocalDateTime arrival, LocalDateTime departure);

    @Query(" {'dates.bookFrom' : { $gte : ?0}, 'dates.bookTo' : { $lte : ?1}}")
    Iterable<Booking> findByBookingBetween(LocalDateTime arrival, LocalDateTime departure);

    @Query(" {'dates.bookFrom' : { $lt : ?1}, 'dates.bookTo' : { $gt : ?1}}")
    Iterable<Booking> findByBookingAfter(LocalDateTime arrival, LocalDateTime departure);

    @Query("{ 'dates.bookTo' : {  $lt: ?0 } }")
    List<Booking> findByBookToIsLessThanEqual(LocalDate arrival);

}

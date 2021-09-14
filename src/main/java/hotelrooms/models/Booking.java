package hotelrooms.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;



@Document(collection = "Booking")
public class Booking {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    @NotNull
    private String roomId;
    private Dates dates = new Dates();
	private String userId;



    private int totalDays;



    public Booking(String roomId, String userId, LocalDateTime bookFrom, LocalDateTime bookTo) {
        this.roomId = roomId;
        this.dates.setBookFrom(bookFrom);
        this.dates.setBookTo(bookTo); 
        this.userId = userId;

    }

    public Booking(String id) {
        this.id = id;
    }


    public Booking(){}



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

   

    public Dates getDates() {
		return dates;
	}

	public void setDates(Dates dates) {
		this.dates = dates;
	}

	public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }




}

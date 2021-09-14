package hotelrooms.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Dates")
public class Dates {
	 @Id
	    private String id;
	@NotNull
	private @NotNull LocalDateTime bookFrom;
	@NotNull
	private @NotNull LocalDateTime bookTo;
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Dates(String id, @NotNull @NotNull LocalDateTime bookFrom, @NotNull @NotNull LocalDateTime bookTo) {
		super();
		this.id = id;
		this.bookFrom = bookFrom;
		this.bookTo = bookTo;
	}



	public LocalDateTime getBookFrom() {
		return bookFrom;
	}



	public void setBookFrom(LocalDateTime bookFrom) {
		this.bookFrom = bookFrom;
	}



	public LocalDateTime getBookTo() {
		return bookTo;
	}



	public void setBookTo(LocalDateTime bookTo) {
		this.bookTo = bookTo;
	}



	public Dates() {
	}
}
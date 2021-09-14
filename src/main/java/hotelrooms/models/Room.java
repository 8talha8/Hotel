package hotelrooms.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Rooms")
public class Room {

    @Id

    private String id;
    private String name;
    private Double price;

    private int beds;



    public Room(String id,String name, int beds, Double price) {
        this.id = id;
        this.name = name;
        this.beds = beds;
        this.price = price;
    }


  

    public Room(){}



    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {

        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBeds() {
        return beds;
    }
}

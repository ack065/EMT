package mk.ukim.finki.emt.lab.Model.dto;
import lombok.Data;
import mk.ukim.finki.emt.lab.Model.Category;

@Data
public class BookingDTO {

    private String name;

    private Category category;

    private Long hostID;

    private int numOfRooms;
    private Double price;

    public BookingDTO() {
    }

    public BookingDTO(String name, Category category, Long hostID, int numOfRooms, Double price) {
        this.name = name;
        this.category = category;
        this.hostID = hostID;
        this.numOfRooms = numOfRooms;
        this.price = price;
    }

}
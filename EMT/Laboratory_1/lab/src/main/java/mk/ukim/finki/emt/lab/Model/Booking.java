package mk.ukim.finki.emt.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BOOKINGS")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Host host;

    private int numOfRooms;

    private boolean booked;

    public Booking() {
    }
    public Booking(String name, Category category, Host host, int numOfRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numOfRooms = numOfRooms;
        this.booked = false;
    }
}
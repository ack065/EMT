package mk.ukim.finki.emt.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "COUNTRIES")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    private String continent;

    public Country() {
    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
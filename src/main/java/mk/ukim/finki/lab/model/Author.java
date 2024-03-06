package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
public class Author {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(name="date_of_birth")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate dateOfBirth;
    String surname;
    String biography;
    public Author(){

    }

    public Author(Long id, String name, String surname, String biography)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.biography = biography;
    }
}

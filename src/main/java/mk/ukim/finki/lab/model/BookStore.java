package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String address;

    @OneToMany(mappedBy = "bookStore")

    public List<Book> booksInStore;
    public BookStore(String name, String city, String address) {
        this.name = name;
        this.booksInStore = new ArrayList<>();
        this.city = city;
        this.address = address;
        //this.id = (long) (Math.random() * 1000);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }
}

package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String title;
    private String genre;
    private int year;
    @OneToMany
    private List<Author> authors;
    @ManyToOne
    private BookStore bookStore;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews;
    public Book(){}
    public Book(String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.bookStore = bookStore;
        //this.id = new Random().nextLong();
        this.reviews = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookStore getBookStore() {
        return bookStore;
    }

    public Long getId() {
        return id;
    }
}

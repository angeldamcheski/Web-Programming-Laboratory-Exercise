package mk.ukim.finki.lab.repository.inmemory;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class BookStoreRepository {
    private List<BookStore> bookStores;
    @PostConstruct
    public void init()
    {
        this.bookStores = new ArrayList<>();
        bookStores.add(new BookStore("Book Haven", "Fictionville", "123 Story Lane"));
        bookStores.add(new BookStore("Literary Oasis", "Readington", "456 Prose Street"));
        bookStores.add(new BookStore("Page Turner Books", "Novelburg", "789 Plot Avenue"));
        bookStores.add(new BookStore("Chapter Chronicles", "Imaginaria", "101 Fantasy Boulevard"));
        bookStores.add(new BookStore("Verse & Vision", "Poet City", "234 Rhyme Square"));
    }

    public List<BookStore> findAll(){
        return bookStores;
    }
    public BookStore findById(Long id){
        return bookStores.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }
}

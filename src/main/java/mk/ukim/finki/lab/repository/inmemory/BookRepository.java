package mk.ukim.finki.lab.repository.inmemory;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.BookStore;
import mk.ukim.finki.lab.repository.AuthorRepositoryJPA;
import mk.ukim.finki.lab.repository.BookRepositoryJPA;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;


public class BookRepository {
    private List<Book> bookList = null;


    @PostConstruct
    public void init()
    {
        bookList = new ArrayList<>();

        bookList.add(new Book("978-0439708180", "Harry Potter and the Sorcerer's Stone", "Fantasy", 1997, new ArrayList<Author>(), new BookStore("Book Haven", "Fictionville", "123 Story Lane")));
        bookList.add(new Book("978-0451524935", "1984", "Dystopian", 1949, new ArrayList<Author>(), new BookStore("Literary Oasis", "Readington", "456 Prose Street")));
        bookList.add(new Book("978-0007119295", "Murder on the Orient Express", "Mystery", 1934, new ArrayList<Author>(), new BookStore("Page Turner Books", "Novelburg", "789 Plot Avenue")));
        bookList.add(new Book("978-0061120084", "To Kill a Mockingbird", "Novel", 1960, new ArrayList<Author>(), new BookStore("Chapter Chronicles", "Imaginaria", "101 Fantasy Boulevard")));
        bookList.add(new Book("978-0451160917", "It", "Horror", 1986, new ArrayList<Author>(), new BookStore("Verse & Vision", "Poet City", "234 Rhyme Square")));

    }
    public List<Book> findAll(){
        return bookList;
    }
    public Book findByIsbn(String isbn){
        return bookList.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }
    public Author addAuthorToBook(Author author, Book book){
        Book bookToAddIn = bookList.stream().filter(b->b.getTitle().equals(book.getTitle())).findFirst().orElse(null);
//        bookToAddIn.get().getAuthors().add(author);
        bookToAddIn.getAuthors().add(author);

        return author;
    }
    public Book findById(Long id){
        return bookList.stream().filter(b->b.getId().equals(id)).findFirst().orElse(null);
    }
    public void addBook(Book b) {
        bookList.add(b);

    }
}

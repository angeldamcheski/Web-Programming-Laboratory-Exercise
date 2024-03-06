package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listBooks();
    //Optional<Author> addAuthorToBook(Long authorId, String isbn);

    //    @Override
    //    public Optional<Author> addAuthorToBook(Long authorId, String isbn) {
    //        Optional<Author> a = authorRepository.findById(authorId);
    //        Book b = bookRepository.findByIsbn(isbn);
    //        if(a.isPresent()){
    //            Author at = a.get();
    //            authorRepository.save(at);
    //            //bookRepository.addAuthorToBook(at, b);
    //            b.getAuthors().add(at);
    //        }
    //        return a;
    //    }
    Optional<Author> addAuthorToBook(Author a, Book b);

    Book findBookByIsbn(String isbn);
    void addBook(Book book);

    Optional<Book> findBookById(Long bookId);

}

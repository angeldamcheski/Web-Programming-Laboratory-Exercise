package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookRepositoryJPA extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
    @Query("UPDATE Book b SET b.authors = :author WHERE b.id = :bookId")
    Optional<Author> addAuthorToBook(Author a, Book b);
    void deleteBookById(Long id);


}

package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface BookStoreRepositoryJPA extends JpaRepository<BookStore, Long> {
    Optional<BookStore> findById(Long id);
}

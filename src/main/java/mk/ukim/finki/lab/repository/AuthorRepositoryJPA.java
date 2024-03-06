package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AuthorRepositoryJPA extends JpaRepository<Author, Long> {
    Optional<Author> findById(Long id);
    List<Author> findAll();
}

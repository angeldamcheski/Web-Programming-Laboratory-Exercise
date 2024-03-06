package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Author;

import java.util.List;
import java.util.Optional;


public interface AuthorService {
    List<Author> listAuthors();
    Optional<Author> findById(Long id);
}

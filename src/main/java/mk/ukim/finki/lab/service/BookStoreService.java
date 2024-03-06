package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.BookStore;

import java.util.List;
import java.util.Optional;

public interface BookStoreService {
    public List<BookStore> findAll();
    public Optional<BookStore> findById(Long id);
}

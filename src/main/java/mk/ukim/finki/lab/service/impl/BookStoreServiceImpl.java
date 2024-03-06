package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.BookStore;
import mk.ukim.finki.lab.repository.BookStoreRepositoryJPA;
import mk.ukim.finki.lab.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreServiceImpl implements BookStoreService {
    private final BookStoreRepositoryJPA bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepositoryJPA bookStoreRepository){
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }


    @Override
    public Optional<BookStore> findById(Long id){
        return bookStoreRepository.findById(id);
    }
}

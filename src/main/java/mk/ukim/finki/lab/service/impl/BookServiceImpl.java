package mk.ukim.finki.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.BookStore;
import mk.ukim.finki.lab.model.Review;
import mk.ukim.finki.lab.repository.AuthorRepositoryJPA;
import mk.ukim.finki.lab.repository.BookRepositoryJPA;
import mk.ukim.finki.lab.repository.BookStoreRepositoryJPA;
import mk.ukim.finki.lab.repository.ReviewRepositoryJPA;
import mk.ukim.finki.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepositoryJPA bookRepository;
    private final BookStoreRepositoryJPA bookStoreRepositoryJPA;
    private final AuthorRepositoryJPA authorRepository;
    private final ReviewRepositoryJPA reviewRepositoryJPA;

    public BookServiceImpl(BookRepositoryJPA bookRepository, AuthorRepositoryJPA authorRepository, BookStoreRepositoryJPA bookStoreRepositoryJPA,
                           ReviewRepositoryJPA reviewRepositoryJPA) {
        this.bookRepository = bookRepository;
        this.bookStoreRepositoryJPA = bookStoreRepositoryJPA;
        this.authorRepository = authorRepository;
        this.reviewRepositoryJPA = reviewRepositoryJPA;
    }
    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Author> addAuthorToBook(Author a, Book b) {
        b.getAuthors().add(a);
        return Optional.of(a);
    }

    public void addReview(Book b, Review review){
        reviewRepositoryJPA.save(review);
    }
//    @Override
//    public Optional<Author> addAuthorToBook(Long authorId, String isbn) {
//        return Optional.empty();
//    }

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
//    @Override
//    public Optional<Author> addAuthorToBook(Author a, Book b){
//        b.getAuthors().add(a);
//        return Optional.of(a);
//    }
    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }


    public void addBook(Book b){
        bookRepository.save(b);
    }

    public Optional<Book> findBookById(Long id)
    {
        //return bookRepository.findAll().stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        //return bookRepository.findById(id);
        return bookRepository.findById(id);
    }
    public void deleteReview(Long id){
        reviewRepositoryJPA.deleteById(id);
    }
    public Optional<Review> findReviewById(Long id){
        return reviewRepositoryJPA.findById(id);
    }
    @Transactional
    public void deleteBookById(Long id){
        bookRepository.deleteBookById(id);
    }

    @Transactional
    public void edit(String title, String isbn, String genre, int year, String storeId) {
        Book b = this.bookRepository.findByIsbn(isbn);
        Optional<BookStore> bs = this.bookStoreRepositoryJPA.findById(Long.parseLong(storeId));
        b.setTitle(title);
        b.setIsbn(isbn);
        b.setGenre(genre);
        b.setYear(year);
        b.setBookStore(bs.get());
    }
    @Transactional
    public void editReview(Long reviewId,Integer rating, String comment, LocalDateTime timestamp){
        Optional<Review> review = reviewRepositoryJPA.findById(reviewId);
        review.get().setScore(rating);
        review.get().setDescription(comment);
        review.get().setTimestamp(timestamp);

    }
    public List<Review> getReviewsInTimeRange(LocalDateTime from, LocalDateTime to){
        return reviewRepositoryJPA.findReviewsInRange(from, to);
    }
    public List<Review> findReviewByDescriptionContaining(String queryText){
        return reviewRepositoryJPA.findReviewByDescriptionContaining(queryText);
    }
}

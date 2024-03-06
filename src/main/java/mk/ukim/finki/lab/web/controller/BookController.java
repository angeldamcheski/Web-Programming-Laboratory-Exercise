package mk.ukim.finki.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.BookStore;
import mk.ukim.finki.lab.model.Review;
import mk.ukim.finki.lab.service.impl.AuthorServiceImpl;
import mk.ukim.finki.lab.service.impl.BookServiceImpl;
import mk.ukim.finki.lab.service.impl.BookStoreServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookServiceImpl bookService;
    private final BookStoreServiceImpl bookStoreService;
    private final AuthorServiceImpl authorService;
    public BookController(BookServiceImpl bookService, AuthorServiceImpl authorService, BookStoreServiceImpl bookStoreService){
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
        this.authorService = authorService;
    }
    @GetMapping("")
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("listBooks", bookService.listBooks());
        model.addAttribute("listBookStores",bookStoreService.findAll());
        return "listBooks";
    }
    @GetMapping("/authors")
    public String getAuthorList(Model model){
        model.addAttribute("listAuthors",authorService.listAuthors());
        return "authorList";
    }
    @GetMapping("/add")
    public String getAddBook(Model model){
        model.addAttribute("bookStores",bookStoreService.findAll());
        return "add-book";
    }
//    @PostMapping("/add")
//    public String addBook(){
//        return "redirect:/books";
//    }
    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                          @RequestParam String isbn,
                          @RequestParam String genre,
                          @RequestParam int year,
                          @RequestParam String storeId,
                          Model model){
        Long id = Long.parseLong(storeId);
        Book b = new Book(isbn, title, genre, year, new ArrayList<>(), bookStoreService.findById(id).orElseThrow());
        bookService.addBook(b);
        return "redirect:/books";
    }
    @GetMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId, Model model){
        if(bookService.listBooks().stream().noneMatch(b->b.getId().equals(bookId))){
            return "redirect:/books";
        }
        else{
            Book b = bookService.findBookById(bookId).orElseThrow();
            model.addAttribute("book", b);
            model.addAttribute("bookStores",bookStoreService.findAll());
            return "edit-book";
        }

    }
    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam String storeId){
        Long id = Long.parseLong(storeId);
//        Book b = bookService.findBookById(bookId).orElseThrow();
//        b.setTitle(title);
//        b.setIsbn(isbn);
//        b.setGenre(genre);
//        b.setYear(year);
//        b.setBookStore(bookStoreService.findById(id).orElseThrow());
        this.bookService.edit(title, isbn, genre, year, storeId);
        return "redirect:/books";
    }
    @GetMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable Long bookId){
        Book b = bookService.findBookById(bookId).orElseThrow();
        //bookService.listBooks().remove(b);
        //bookService.deleteBookById(bookId);
        bookService.deleteBookById(bookId);
        return "redirect:/books";
    }
    @GetMapping("/review/{bookId}")
    public String getBookReview(@PathVariable Long bookId, Model model){
        Optional<Book> b = bookService.findBookById(bookId);
        model.addAttribute("reviewBook", b);
        return "reviewTemplate";
    }
    @PostMapping("/review/add/{bookId}")
    public String addAReview(@PathVariable Long bookId,
                             @RequestParam Integer rating,
                             @RequestParam String comment , @RequestParam LocalDateTime timestamp){
        Optional<Book> b = bookService.findBookById(bookId);
        //b.get().getReviews().add(new Review(rating, comment, b.get(), timestamp));
        bookService.addReview(b.get(), new Review(rating, comment, b.get(), timestamp));
        return "redirect:/books";
    }
    @GetMapping("/review/delete/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId){
        bookService.deleteReview(reviewId);
        return "redirect:/books";
    }
    @GetMapping("/review/edit/{reviewId}")
    public String getEditReview(@PathVariable Long reviewId,Model model){
        Optional<Review> review = bookService.findReviewById(reviewId);
        model.addAttribute("currentReview", review.get());
        return "edit-review";
    }
    @PostMapping("/review/edit/{reviewId}")
    public String editReview(@PathVariable Long reviewId, @RequestParam Integer rating,
                             @RequestParam String comment,
                             @RequestParam LocalDateTime timestamp){
        bookService.editReview(reviewId,rating, comment, timestamp);
        return "redirect:/books";
    }
    @GetMapping("/review/search/{bookId}")
    public String searchBookReview(@PathVariable Long bookId, @RequestParam String searchQuery, Model model){
        Optional<Book> b = bookService.findBookById(bookId);
        List<Review> matchingReviews = bookService.findReviewByDescriptionContaining(searchQuery);
        b.get().setReviews(matchingReviews);
        model.addAttribute("reviewBook", b.get());
        return "redirect:/books/review/"+bookId;
    }
    @PostMapping()
    public String chooseABook(Model model, HttpServletRequest req, @RequestParam String bookIsbn){
        model.addAttribute("currentIsbn", bookIsbn);
        req.getSession().setAttribute("currentIsbn", bookIsbn);
        return "redirect:/author";
    }
}

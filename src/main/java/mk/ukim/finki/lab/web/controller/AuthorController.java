package mk.ukim.finki.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.service.impl.AuthorServiceImpl;
import mk.ukim.finki.lab.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorServiceImpl authorService;
    private final BookServiceImpl bookService;

    public AuthorController(BookServiceImpl bookService, AuthorServiceImpl authorService){
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping()
    public String getAuthors(Model model){
        model.addAttribute("listAuthors",authorService.listAuthors());
        return "authorList";
    }
    @PostMapping()
    public String selectAuthor(Model model, HttpServletRequest req, @RequestParam Long authorId){
        String isbn = (String) req.getSession().getAttribute("currentIsbn");
        Book b = bookService.findBookByIsbn(isbn);
        Optional<Author> optionalAuthor = authorService.findById(authorId);
        if(optionalAuthor.isPresent()){
            b.getAuthors().add(optionalAuthor.get());
        }else{
            throw new RuntimeException();
        }
        req.getSession().setAttribute("currentBook",b);
        return "bookDetails";
    }
}

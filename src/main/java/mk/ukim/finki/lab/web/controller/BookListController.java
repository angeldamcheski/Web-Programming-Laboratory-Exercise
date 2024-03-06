package mk.ukim.finki.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.lab.service.BookService;
import mk.ukim.finki.lab.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/listbooks")
public class BookListController {

    private final BookServiceImpl bookService;
    public BookListController(BookServiceImpl bookService){
        this.bookService = bookService;
    }
    @GetMapping()
    public String getBookList(Model model){
        return "listBooks";
    }
    @PostMapping()
    public String chooseABook(Model model,
                              @RequestParam String isbn, HttpServletRequest request){
        request.getSession().setAttribute("currentIsbn",isbn);
        model.addAttribute("currentIsbn",isbn);
        return "redirect:/author";
    }
}

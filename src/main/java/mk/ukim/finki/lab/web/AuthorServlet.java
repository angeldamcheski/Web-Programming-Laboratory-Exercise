//package mk.ukim.finki.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.lab.model.Author;
//import mk.ukim.finki.lab.model.Book;
//import mk.ukim.finki.lab.service.impl.AuthorServiceImpl;
//import mk.ukim.finki.lab.service.impl.BookServiceImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name="author-servlet", urlPatterns = "/servlet/author")
//public class AuthorServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//    private final AuthorServiceImpl authorService;
//    private final BookServiceImpl bookService;
//    public AuthorServlet(SpringTemplateEngine springTemplateEngine, AuthorServiceImpl authorService, BookServiceImpl bookService){
//        this.authorService = authorService;
//        this.springTemplateEngine = springTemplateEngine;
//        this.bookService = bookService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req,resp);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("listAuthors", authorService.listAuthors());
//        springTemplateEngine.process(
//                "authorList",
//                context,
//                resp.getWriter()
//        );
//    }
//
////    @Override
////    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        //Author authorId = authorService.findById(Long.parseLong(req.getParameter("authorId")));
////        System.out.println(authorId.getBiography());
////        req.getSession().setAttribute("chosenAuthor", authorId);
////        req.getSession().setAttribute("currentBook",bookService.findBookByIsbn((String)req.getSession().getAttribute("currentIsbn")));
////        bookService.addAuthorToBook(authorId.getId(), (String) req.getSession().getAttribute("currentIsbn"));
////        resp.sendRedirect("/bookdetails");
////    }
//}

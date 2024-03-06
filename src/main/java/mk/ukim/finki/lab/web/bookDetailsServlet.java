//package mk.ukim.finki.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.lab.service.impl.BookServiceImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name="book-details", urlPatterns = "/bookdetails")
//public class bookDetailsServlet extends HttpServlet {
//    private final BookServiceImpl bookService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public bookDetailsServlet(BookServiceImpl bookService, SpringTemplateEngine springTemplateEngine){
//        this.bookService = bookService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //super.doGet(req, resp);
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("listBooks",bookService.listBooks());
//        springTemplateEngine.process("bookDetails.html",context, resp.getWriter());
//
//
//    }
//}

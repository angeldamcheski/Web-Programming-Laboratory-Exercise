//package mk.ukim.finki.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.lab.service.BookService;
//import mk.ukim.finki.lab.service.impl.BookServiceImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(name="bookListServlet",urlPatterns = "/servlet/listbooks")
//public class BookListServlet extends HttpServlet {
//    private final BookServiceImpl bookService;
//    private final SpringTemplateEngine springTemplateEngine;
//    public BookListServlet(BookServiceImpl bookService, SpringTemplateEngine springTemplateEngine){
//        this.bookService = bookService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req,resp);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("listBooks",bookService.listBooks());
//
//        springTemplateEngine.process(
//                "listBooks.html",
//                context,
//                resp.getWriter()
//        );
//
//
//
//        //        PrintWriter out = resp.getWriter();
////        out.println("<head>");
////        out.println("<body>");
////        out.println("<ul>");
////        bookService.listBooks().forEach(book -> out.format("<li><h1>%s</h1></li>",book.getTitle()));
////        out.println("</ul>");
////        out.println("</body>");
////        out.println("</head>");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //super.doPost(req, resp);
//        String isbn = req.getParameter("bookIsbn");
//        req.getSession().setAttribute("currentIsbn", isbn);
//        //IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
//        //WebContext context = new WebContext(webExchange);
//        //context.setVariable("currentBook",isbn);
//
//
//
//        //System.out.println(isbn);
//        resp.sendRedirect(req.getContextPath() +"/author");
//    }
//}

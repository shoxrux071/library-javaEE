package uz.shox.lib.servlets;

import uz.shox.lib.config.ApplicationContexHolder;
import uz.shox.lib.domains.PageInfo;
import uz.shox.lib.enums.Genre;
import uz.shox.lib.enums.Language;
import uz.shox.lib.service.book.BookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 12/11/22 20:19 (Saturday)
 * library-javaEE/IntelliJ IDEA
 */
@WebServlet("")
public class HomeServlet extends HttpServlet {
    BookServiceImpl bookService = ApplicationContexHolder.getBean(BookServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(Optional.ofNullable(req.getParameter("page")).orElse("1"));
        int limit = Integer.parseInt(Optional.ofNullable(req.getParameter("limit")).orElse("12"));
        String search = Optional.ofNullable(req.getParameter("search")).orElse("");

        req.setAttribute("books", bookService.getAll(search, page, limit));
        req.setAttribute("pageInfo", PageInfo.builder()
                .hasPrevious(bookService.hasPrevious(page))
                .hasNext(bookService.hasNext(search, page, limit))
                .number(page)
                .totalPages(bookService.totalPage(search, limit))
                .build());
        req.setAttribute("search", search);
        req.setAttribute("genres", Genre.values());
        req.setAttribute("languages", Language.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/main.jsp");
        dispatcher.forward(req, resp);

    }
}

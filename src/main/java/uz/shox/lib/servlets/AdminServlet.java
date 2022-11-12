package uz.shox.lib.servlets;

import uz.shox.lib.config.ApplicationContexHolder;
import uz.shox.lib.dtos.book.BookUpdateDTO;
import uz.shox.lib.dtos.user.UserDTO;
import uz.shox.lib.enums.BookStatus;
import uz.shox.lib.exception.InvalidInputException;
import uz.shox.lib.exception.NotFoundException;
import uz.shox.lib.service.book.BookServiceImpl;
import uz.shox.lib.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 12/11/22 20:13 (Saturday)
 * library-javaEE/IntelliJ IDEA
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    BookServiceImpl bookService = ApplicationContexHolder.getBean(BookServiceImpl.class);
    UserServiceImpl userService = ApplicationContexHolder.getBean(UserServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkRequestSender(req);
        req.setAttribute("books", bookService.getAllByStatus(BookStatus.PENDING));
        req.getRequestDispatcher("views/AdminPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkRequestSender(req);
        String action = req.getParameter("action");
        Long bookId = Long.parseLong(req.getParameter("id"));
        BookStatus status = switch (action) {
            case "delete" -> BookStatus.DELETED;
            case "accept" -> BookStatus.ACTIVE;
            default -> throw new InvalidInputException("Invalid approval");
        };

        BookUpdateDTO updateDTO = BookUpdateDTO.builder()
                .id(bookId)
                .status(status)
                .build();
        bookService.update(updateDTO);
        resp.sendRedirect("/admin");
    }

    private void checkRequestSender(HttpServletRequest req) throws NotFoundException {
        Cookie cookie1 = Arrays.stream(req.getCookies()).filter(cookie -> cookie.getName().equals("session_user")).findFirst().orElse(null);
        if (cookie1 == null)
            throw new NotFoundException("Page not found");
        String userEmail = cookie1.getValue();
        UserDTO byEmail = userService.getByEmail(userEmail);
        if (!(byEmail.getStatus().getPriority() > 50))
            throw new NotFoundException("Page not found");
    }
}

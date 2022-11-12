package uz.shox.lib.servlets.handlers;

import uz.shox.lib.dtos.error.ErrorDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 12/11/22 20:23 (Saturday)
 * library-javaEE/IntelliJ IDEA
 */
@WebServlet("/404")
public class NotFoundExceptionHandler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        String message = throwable.getMessage();
        String requestURI = req.getRequestURI();
        ErrorDto error = ErrorDto.builder()
                .message(message)
                .path(requestURI)
                .build();
        req.setAttribute("error", error);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/errors/404.jsp");
        dispatcher.forward(req, resp);
    }
}


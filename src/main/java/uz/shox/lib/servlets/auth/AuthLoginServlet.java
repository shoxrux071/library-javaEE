package uz.shox.lib.servlets.auth;

import uz.shox.lib.config.ApplicationContexHolder;
import uz.shox.lib.dtos.user.UserDTO;
import uz.shox.lib.dtos.user.UserLoginDTO;
import uz.shox.lib.service.user.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 10/11/22 00:38 (Thursday)
 * library-javaEE/IntelliJ IDEA
 */
@WebServlet("/login")
public class AuthLoginServlet extends HttpServlet {
   private final UserServiceImpl userService = ApplicationContexHolder.getBean(UserServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/auth/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserLoginDTO userLoginDTO = new UserLoginDTO(email, password);
        UserDTO user = userService.login(userLoginDTO);
        Cookie cookie = new Cookie("session_user", user.getEmail());
        cookie.setMaxAge(900);
        resp.addCookie(cookie);
        resp.sendRedirect("/");
    }
}

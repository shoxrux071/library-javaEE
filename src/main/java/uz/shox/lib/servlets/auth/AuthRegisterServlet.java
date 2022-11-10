package uz.shox.lib.servlets.auth;

import uz.shox.lib.config.ApplicationContexHolder;
import uz.shox.lib.dtos.user.UserCreateDTO;
import uz.shox.lib.dtos.user.UserDTO;
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
 * @since 11/11/22 00:08 (Friday)
 * library-javaEE/IntelliJ IDEA
 */
@WebServlet("/register")
public class AuthRegisterServlet extends HttpServlet {
    private  final UserServiceImpl userService = ApplicationContexHolder.getBean(UserServiceImpl.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("views/auth/register");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        UserCreateDTO userCreateDTO = UserCreateDTO.builder()
                .email(email)
                .name(name)
                .surname(surname)
                .password(password)
                .build();
        UserDTO userDTO = userService.create(userCreateDTO);
        Cookie cookie = new Cookie("session_user", userDTO.getEmail());
        resp.addCookie(cookie);
        resp.sendRedirect("/");
    }
}

package uz.shox.lib.filters;

import uz.shox.lib.config.ApplicationContexHolder;
import uz.shox.lib.service.user.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 12/11/22 20:25 (Saturday)
 * library-javaEE/IntelliJ IDEA
 */
public class GlobalFilter implements Filter {
    private final List<String> WHITE_LIST = new ArrayList<>(Arrays.asList(
            "/login",
            "/register"
    ));
    private final UserServiceImpl userService = ApplicationContexHolder.getBean(UserServiceImpl.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (WHITE_LIST.contains(req.getRequestURI())) {
            chain.doFilter(req, response);
            return;
        }
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("session_user")) {
                    String emailAddress = cookie.getValue();
                    req.setAttribute("user", userService.getByEmail(emailAddress));
                    chain.doFilter(req, response);
                    return;
                }
            }
        }
        ((HttpServletResponse) response).sendRedirect("/login");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
    }
}

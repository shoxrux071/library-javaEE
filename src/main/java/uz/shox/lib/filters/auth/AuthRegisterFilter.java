package uz.shox.lib.filters.auth;

import uz.shox.lib.exception.InvalidInputException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 12/11/22 20:26 (Saturday)
 * library-javaEE/IntelliJ IDEA
 */
//@WebFilter("/register")
public class AuthRegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String method = ((HttpServletRequest) req).getMethod();
        if ("post".equalsIgnoreCase(method)) {
            if (Objects.isNull(username))
                throw new InvalidInputException("Email can not be null");
            if (Objects.isNull(password))
                throw new InvalidInputException("Password can not be null");
            if (!Objects.equals(password, confirmPassword))
                throw new InvalidInputException("Password did not match");
        }
        chain.doFilter(req, res);
    }


}


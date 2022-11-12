package uz.shox.lib.filters.book;

import uz.shox.lib.exception.InvalidInputException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 12/11/22 20:27 (Saturday)
 * library-javaEE/IntelliJ IDEA
 */
public class BookApprovalFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String method = ((HttpServletRequest) request).getMethod();
        if (method.equalsIgnoreCase("Post")) {
            if (action == null || id == null) {
                throw new InvalidInputException("Book approval has received null values");
            }
            try {
                int bookId = Integer.parseInt(id);
            } catch (Exception e) {
                throw new InvalidInputException("Book id has received not numeric values");
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}


package uz.shox.lib.filters.book;

import uz.shox.lib.exception.InvalidInputException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Objects;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 12/11/22 20:27 (Saturday)
 * library-javaEE/IntelliJ IDEA
 */
public class BookUploadFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");
        String language = request.getParameter("language");
        String pageCount = request.getParameter("pageCount");

        HttpServletRequest req = (HttpServletRequest) request;
        String method = req.getMethod();
        if (method.equalsIgnoreCase("Post")) {
            Part file = req.getPart("file");
            if (Objects.isNull(name) || Objects.isNull(author) || Objects.isNull(genre) || Objects.isNull(language) || Objects.isNull(pageCount))
                throw new InvalidInputException("File upload data can not null");
            if (!file.getContentType().equalsIgnoreCase("application/pdf"))
                throw new InvalidInputException("Only pdf files must be uploaded");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

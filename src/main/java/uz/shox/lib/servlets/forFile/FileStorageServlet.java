package uz.shox.lib.servlets.forFile;

import uz.shox.lib.config.ApplicationContexHolder;
import uz.shox.lib.dtos.uploads.UploadsDTO;
import uz.shox.lib.service.book.BookServiceImpl;
import uz.shox.lib.service.file.FileStorageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 11/11/22 00:20 (Friday)
 * library-javaEE/IntelliJ IDEA
 */
@WebServlet("/uploads/*")
@MultipartConfig
public class FileStorageServlet extends HttpServlet {
    private final BookServiceImpl bookService = ApplicationContexHolder.getBean(BookServiceImpl.class);
    private final FileStorageServiceImpl fileStorageService = ApplicationContexHolder.getBean(FileStorageServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        UploadsDTO uploadsDTO = fileStorageService.getByPath(path);
        CompletableFuture.runAsync(() -> {
            if (uploadsDTO.getContentType().equals("application/pdf")){

            }
        })

    }
}

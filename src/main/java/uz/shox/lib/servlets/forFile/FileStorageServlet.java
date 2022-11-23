package uz.shox.lib.servlets.forFile;

import uz.shox.lib.config.ApplicationContexHolder;
import uz.shox.lib.dtos.book.BookCreateDTO;
import uz.shox.lib.dtos.uploads.UploadsDTO;
import uz.shox.lib.enums.Genre;
import uz.shox.lib.enums.Language;
import uz.shox.lib.service.book.BookServiceImpl;
import uz.shox.lib.service.file.FileStorageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            if (uploadsDTO.getContentType().equals("application/pdf")) {
                bookService.updateDownloadCount(uploadsDTO.getId());
            }
            resp.setHeader("Content-disposition", "attachment; filename=" + uploadsDTO.getOriginalName());
            Path path1 = Paths.get("/home/shoxrux/IdeaProjects/library-javaEE/upload", uploadsDTO.getPath());
            ServletOutputStream outputStream = null;
            try {

                outputStream = resp.getOutputStream();
                Files.copy(path1, outputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        Genre genre = Enum.valueOf(Genre.class, req.getParameter("genre"));
        Language language = Enum.valueOf(Language.class, req.getParameter("language"));
        Integer pageCount = Integer.parseInt(req.getParameter("pageCount"));
        BookCreateDTO bookCreateDTO = BookCreateDTO.builder()
                .name(name)
                .author(author)
                .genre(genre)
                .language(language)
                .pageCount(pageCount)
                .description(description)
                .build();

        Part file = req.getPart("file");
        bookService.create(bookCreateDTO, file);
        resp.sendRedirect("/");
    }
}

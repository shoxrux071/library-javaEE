package uz.shox.lib.service.book;

import uz.shox.lib.domains.Book;
import uz.shox.lib.dtos.book.BookCreateDTO;
import uz.shox.lib.dtos.book.BookUpdateDTO;
import uz.shox.lib.enums.BookStatus;
import uz.shox.lib.exception.NotFoundException;

import javax.servlet.http.Part;
import java.util.List;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 04:46 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public interface BookService {
    void create(BookCreateDTO dto, Part book);

    Book get(long id);

    void delete(long l);

    void update(BookUpdateDTO dto) throws NotFoundException;


    List<Book> getAll();

    List<Book> getAll(String searchQuery, Integer page, Integer limit);

    List<Book> getAllByStatus(BookStatus pending);

    void updateDownloadCount(Long uploadFileId);
}

package uz.shox.lib.dtos.book;

import lombok.*;
import uz.shox.lib.domains.Book;
import uz.shox.lib.enums.Genre;
import uz.shox.lib.enums.Language;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:29 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCreateDTO {
    private String name;
    private String description;
    private String author;
    private Genre genre;
    private Language language;
    private int pageCount;
}

package uz.shox.lib.dtos.book;

import lombok.*;
import uz.shox.lib.enums.BookStatus;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:30 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookUpdateDTO {
    private Long id;
    private String name;
    private String description;
    private Integer downloadCount;
    private BookStatus status;
}

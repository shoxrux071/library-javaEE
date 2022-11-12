package uz.shox.lib.domains;

import jakarta.persistence.*;
import lombok.*;
import uz.shox.lib.enums.BookStatus;
import uz.shox.lib.enums.Genre;
import uz.shox.lib.enums.Language;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 08/11/22 00:37 (Tuesday)
 * library-javaEE/IntelliJ IDEA
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String author;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private BookStatus status= BookStatus.PENDING;
    @Enumerated(EnumType.STRING)

    private Language language;
    private Integer pageCount;
    @Builder.Default
    private Integer downloadCount=0;
    @OneToOne(fetch = FetchType.EAGER)
    private Uploads cover;

    @OneToOne(fetch = FetchType.EAGER)
    private Uploads file;
}

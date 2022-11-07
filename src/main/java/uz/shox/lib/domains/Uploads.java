package uz.shox.lib.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 08/11/22 00:53 (Tuesday)
 * library-javaEE/IntelliJ IDEA
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Uploads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private String originalName;
    private String generatedName;
    private long size;
    private String contentType;
}

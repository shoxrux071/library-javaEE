package uz.shox.lib.dtos.uploads;

import lombok.Builder;
import lombok.Data;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:35 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
@Data
@Builder
public class UploadsDTO {
    private Long id;
    private String originalName;
    private String generatedName;
    private String contentType;
    private String path;
    private long size;
}

package uz.shox.lib.dtos.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:31 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ErrorDto {
    private String message;
    private String detailedMessage;
    private String path;
    @Builder.Default
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
}
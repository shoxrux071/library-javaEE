package uz.shox.lib.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:27 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */

@AllArgsConstructor
@Data
public class UserLoginDTO {
    private String email;
    private String password;
}
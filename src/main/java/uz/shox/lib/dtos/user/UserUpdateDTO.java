package uz.shox.lib.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:28 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
@AllArgsConstructor
@Getter
@Setter
public class UserUpdateDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;

}
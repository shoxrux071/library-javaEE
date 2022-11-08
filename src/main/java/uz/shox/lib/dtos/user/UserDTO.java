package uz.shox.lib.dtos.user;

import lombok.*;
import uz.shox.lib.enums.UserStatus;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:26 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String name;
    private String surname;
    private UserStatus status;
}

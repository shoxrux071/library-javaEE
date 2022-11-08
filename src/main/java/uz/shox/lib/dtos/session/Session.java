package uz.shox.lib.dtos.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.shox.lib.dtos.user.UserDTO;
import uz.shox.lib.enums.UserStatus;

import java.util.Objects;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:50 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class Session {

    public static SessionUser sessionUser;

    public static void setSessionUser(UserDTO user) {
        if (Objects.isNull(user)) {
            sessionUser = null;
        } else
            sessionUser = new SessionUser(user);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SessionUser {
        private Long id;
        private String email;
        private UserStatus status;

        public SessionUser(UserDTO userDTO) {
            this.id = userDTO.getId();
            this.email = userDTO.getEmail();
            this.status = userDTO.getStatus();
        }
    }
}

package uz.shox.lib.dtos.user;

import lombok.*;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:25 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @Builder
    public class UserCreateDTO {
        private String email;
        private String password;
        private String name;
        private String surname;
    }


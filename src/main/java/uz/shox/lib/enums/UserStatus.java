package uz.shox.lib.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 08/11/22 00:59 (Tuesday)
 * library-javaEE/IntelliJ IDEA
 */
@AllArgsConstructor
@Getter
public enum UserStatus {
    USER(50),ADMIN(75),SUPER_ADMIN(100);
    private final Integer priority;
}

package uz.shox.lib.exception;

import javax.servlet.ServletException;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:42 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class AuthenticationException extends ServletException {
    public AuthenticationException(String message) {
        super(message);
    }
}

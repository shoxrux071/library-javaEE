package uz.shox.lib.exception;

import javax.servlet.ServletException;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:43 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class AuthorizationException extends ServletException {
    public AuthorizationException(String message) {
        super(message);
    }
}

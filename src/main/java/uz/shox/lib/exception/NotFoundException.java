package uz.shox.lib.exception;

import javax.servlet.ServletException;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:44 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class NotFoundException extends ServletException {
    public NotFoundException(String message) {
        super(message);
    }
}

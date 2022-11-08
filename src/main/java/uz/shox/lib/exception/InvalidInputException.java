package uz.shox.lib.exception;

import javax.servlet.ServletException;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:39 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class InvalidInputException extends ServletException {
    public InvalidInputException(String message) {
        super(message);
    }
}

package uz.shox.lib.config;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 04:26 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class PasswordConfigurer {

    public static String encode(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
    }

    public static boolean matchPassword(String rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }

}

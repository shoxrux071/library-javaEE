package uz.shox.lib.utils;

import uz.shox.lib.config.PasswordConfigurer;
import uz.shox.lib.service.user.UserServiceImpl;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:58 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class BaseUtils {
    private static BaseUtils instance;

    public String encode(String rawPassword) {
        return PasswordConfigurer.encode(rawPassword);
    }

    public boolean matchPassword(String rawPassword, String encodedPassword) {
        return PasswordConfigurer.matchPassword(rawPassword, encodedPassword);

    }
    public static BaseUtils getInstance() {
        if (instance==null){
            instance = new BaseUtils();
        }
        return instance;
    }
}



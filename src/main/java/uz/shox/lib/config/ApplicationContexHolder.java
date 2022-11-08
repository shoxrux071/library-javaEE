package uz.shox.lib.config;

import uz.shox.lib.dao.BookDAO;
import uz.shox.lib.dao.UploadDAO;
import uz.shox.lib.dao.UserDAO;
import uz.shox.lib.service.book.BookServiceImpl;
import uz.shox.lib.service.file.FileStorageServiceImpl;
import uz.shox.lib.service.user.UserServiceImpl;
import uz.shox.lib.utils.BaseUtils;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:53 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class ApplicationContexHolder {

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName){

        return switch (beanName){
            case "BaseUtils" -> (T) BaseUtils.getInstance();
            case "UserServiceImpl" -> (T) UserServiceImpl.getInstance();
            case "BookServiceImpl" -> (T) BookServiceImpl.getInstance();
            case "FileStorageServiceImpl" -> (T) FileStorageServiceImpl.getInstance();
            case "UserDAO" -> (T) UserDAO.getInstance();
            case "BookDAO" -> (T) BookDAO.getInstance();
            case "UploadDAO" -> (T) UploadDAO.getInstance();
            default -> throw new RuntimeException("Bean not found %s".formatted(beanName));
        };
    }

    public static <T> T getBean(Class<T> clazz){
        String simpleName = clazz.getSimpleName();
        return getBean(simpleName);
    }

}

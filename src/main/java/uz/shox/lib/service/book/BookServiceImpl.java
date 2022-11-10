package uz.shox.lib.service.book;

import uz.shox.lib.config.ApplicationContexHolder;
import uz.shox.lib.dao.AbstractDAO;
import uz.shox.lib.dao.BookDAO;
import uz.shox.lib.domains.User;
import uz.shox.lib.dtos.user.UserCreateDTO;
import uz.shox.lib.dtos.user.UserDTO;
import uz.shox.lib.dtos.user.UserLoginDTO;
import uz.shox.lib.dtos.user.UserUpdateDTO;
import uz.shox.lib.exception.AuthenticationException;
import uz.shox.lib.exception.InvalidInputException;
import uz.shox.lib.exception.NotFoundException;
import uz.shox.lib.service.user.UserService;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 04:04 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class BookServiceImpl extends AbstractDAO <BookDAO> implements BookService, Pageable {


}

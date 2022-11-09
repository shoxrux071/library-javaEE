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
public class BookServiceImpl extends AbstractDAO <BookDAO> implements UserService, Pageable {

    private static BookServiceImpl instance;




    public BookServiceImpl() {
        super(ApplicationContexHolder.getBean(BookDAO.class));
    }

    public static BookServiceImpl getInstance() {
        if (instance==null){
            instance = new BookServiceImpl();
        }
        return instance;
    }

    @Override
    public UserDTO create(UserCreateDTO dto) throws InvalidInputException {
          return null;
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public void update(UserUpdateDTO dto) {

    }

    @Override
    public UserDTO login(UserLoginDTO dto) throws InvalidInputException, AuthenticationException {
        return null;
    }

    @Override
    public UserDTO getByEmail(String email) throws NotFoundException {
        return null;
    }

    @Override
    public int getNumberOfPages() {
        return 0;
    }

    @Override
    public PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Printable getPrintable(int pageIndex) throws IndexOutOfBoundsException {
        return null;
    }
}

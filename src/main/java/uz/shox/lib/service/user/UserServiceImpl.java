package uz.shox.lib.service.user;

import uz.shox.lib.dao.AbstractDAO;
import uz.shox.lib.dao.UserDAO;
import uz.shox.lib.domains.User;
import uz.shox.lib.dtos.user.UserDTO;
import uz.shox.lib.dtos.user.UserLoginDTO;
import uz.shox.lib.dtos.user.UserUpdateDTO;
import uz.shox.lib.exception.AuthenticationException;
import uz.shox.lib.exception.InvalidInputException;
import uz.shox.lib.exception.NotFoundException;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:51 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class UserServiceImpl extends AbstractDAO<UserDAO> implements UserService{

    public UserServiceImpl(UserDAO dao) {
        super();
    }

    @Override
    public UserDTO create() throws InvalidInputException {
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
}

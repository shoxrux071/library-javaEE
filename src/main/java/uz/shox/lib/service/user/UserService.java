package uz.shox.lib.service.user;

import uz.shox.lib.domains.Users;
import uz.shox.lib.dtos.user.UserCreateDTO;
import uz.shox.lib.dtos.user.UserDTO;
import uz.shox.lib.dtos.user.UserLoginDTO;
import uz.shox.lib.dtos.user.UserUpdateDTO;
import uz.shox.lib.exception.AuthenticationException;
import uz.shox.lib.exception.InvalidInputException;
import uz.shox.lib.exception.NotFoundException;


/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:35 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public interface UserService {
    UserDTO create(UserCreateDTO dto) throws InvalidInputException;

    Users get(long id);

    void update (UserUpdateDTO dto);

    UserDTO login(UserLoginDTO dto) throws InvalidInputException, AuthenticationException;

    UserDTO getByEmail(String email) throws NotFoundException;
}

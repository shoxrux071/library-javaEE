package uz.shox.lib.service.user;

import uz.shox.lib.config.ApplicationContexHolder;
import uz.shox.lib.dao.AbstractDAO;
import uz.shox.lib.dao.UserDAO;
import uz.shox.lib.domains.Users;
import uz.shox.lib.dtos.user.UserCreateDTO;
import uz.shox.lib.dtos.user.UserDTO;
import uz.shox.lib.dtos.user.UserLoginDTO;
import uz.shox.lib.dtos.user.UserUpdateDTO;
import uz.shox.lib.exception.AuthenticationException;
import uz.shox.lib.exception.InvalidInputException;
import uz.shox.lib.exception.NotFoundException;
import uz.shox.lib.utils.BaseUtils;

import java.util.Optional;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:51 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class UserServiceImpl extends AbstractDAO<UserDAO> implements UserService{

     private static UserServiceImpl instance;

     private final BaseUtils baseUtils = ApplicationContexHolder.getBean(BaseUtils.class);

    public UserServiceImpl() {
        super(ApplicationContexHolder.getBean(UserDAO.class));
    }

    public static UserServiceImpl getInstance() {
       if (instance==null){
           instance = new UserServiceImpl();
       }
       return instance;
    }

    @Override
    public UserDTO create(UserCreateDTO dto) throws InvalidInputException {
        Optional<Users> byEmail = dao.findByEmail(dto.getEmail());
        if (byEmail.isPresent()){
            throw new InvalidInputException("User by email %s already exits".formatted(byEmail.get()));
        }

        Users user = Users.builder()
                .email(dto.getEmail())
                .password(baseUtils.encode(dto.getPassword()))
                .name(dto.getName())
                .surname(dto.getSurname()).build();
        Users savedUser = dao.save(user);

        return UserDTO.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .surname(savedUser.getSurname())
                .name(savedUser.getName()).build();
    }

    @Override
    public Users get(long id) {
        return null;
    }

    @Override
    public void update(UserUpdateDTO dto) {

    }

    @Override
    public UserDTO login(UserLoginDTO dto) throws InvalidInputException, AuthenticationException {
        String email = dto.getEmail();
        Optional<Users> byEmail = dao.findByEmail(email);
        Users user = byEmail.orElseThrow(() -> new InvalidInputException("user not found by email by email %s".formatted(dto.getEmail())));

        if (!baseUtils.matchPassword(dto.getPassword(), user.getPassword())){
            throw new AuthenticationException("bad crediantials");
        }

        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }

    @Override
    public UserDTO getByEmail(String email) throws NotFoundException {
        Optional<Users> user = dao.findByEmail(email);
        Users user1 = user.orElseThrow(() -> new NotFoundException("user not found exception"));
        return UserDTO.builder()
                .id(user1.getId())
                .status(user1.getStatus())
                .email(user1.getEmail())
                .build();
    }



}

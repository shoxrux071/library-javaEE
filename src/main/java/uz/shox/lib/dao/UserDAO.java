package uz.shox.lib.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import uz.shox.lib.domains.User;

import java.util.Optional;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:14 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDAO extends GenericDAO<User,Long> {

    private static UserDAO instance = null;

    public static UserDAO getInstance(){
        if (instance == null){
            instance = new UserDAO();
        }
        return instance;
    }

    public Optional <User> findByEmail(String email){
        Session session = getSession();
        session.beginTransaction();
        Query<User> query = session.createQuery("select t from User t where t.email=:email", User.class);
        User user = query.setParameter("email", email).getSingleResultOrNull();
        session.getTransaction().commit();
        return Optional.ofNullable(user);
    }



}

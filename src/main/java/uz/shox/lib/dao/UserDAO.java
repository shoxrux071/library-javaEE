package uz.shox.lib.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import uz.shox.lib.domains.Users;

import java.util.Optional;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:14 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDAO extends GenericDAO<Users,Long> {

    private static UserDAO instance = null;

    public static UserDAO getInstance(){
        if (instance == null){
            instance = new UserDAO();
        }
        return instance;
    }

    public Optional <Users> findByEmail(String email){
        Session session = getSession();
        session.beginTransaction();
        Query<Users> query = session.createQuery("select t from Users t where t.email=:email", Users.class);
        Users user = query.setParameter("email", email).getSingleResultOrNull();
        session.getTransaction().commit();
        return Optional.ofNullable(user);
    }



}

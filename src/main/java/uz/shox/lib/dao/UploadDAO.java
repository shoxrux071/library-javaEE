package uz.shox.lib.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import uz.shox.lib.domains.Uploads;

import java.util.Optional;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 03:26 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class UploadDAO extends GenericDAO<Uploads,Long>{
    private static UploadDAO instance = null;

    public static UploadDAO getInstance(){
        if (instance == null){
            instance = new UploadDAO();
        }
        return instance;
    }

    public Optional<Uploads> getByPath(String path){
        Session session = getSession();
        session.beginTransaction();
        Query<Uploads> query = session.createQuery("select t from Uploads t where t.path=:path", Uploads.class);
        Uploads upload = query.setParameter("path", path).getSingleResultOrNull();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(upload);
    }
}

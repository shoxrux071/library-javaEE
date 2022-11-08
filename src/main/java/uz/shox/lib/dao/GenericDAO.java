package uz.shox.lib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.shox.lib.config.HibernateConfigurer;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:57 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class GenericDAO <T,ID> implements BaseDAO{
     protected SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();

     private  final  Class<T> persistentClass;
    @SuppressWarnings("unchecked")
    public GenericDAO() {
       this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
               .getGenericSuperclass())
               .getActualTypeArguments()[0];
    }

    public T save (T entity){
        Session currentSession = getSession();
        currentSession.beginTransaction();
        currentSession.persist(entity);
        currentSession.getTransaction().commit();
        currentSession.close();
        return entity;
    }

    public void deleteById( ID id) throws SQLException {
        T entity = findById(id);
        if(entity == null){
            try {
                throw new SQLException("object is not found with the id ".formatted(id));
            }
            catch (SQLException e ){
                System.out.println(e.getErrorCode());
            }
        }
        Session session = getSession();
        session.beginTransaction();
        session.remove(entity);
        session.close();
    }

    private T findById(ID id ) {
        Session session = getSession();
        session.beginTransaction();
        T t = session.get(persistentClass, id);
        session.close();
        return t;
    }


    protected Session getSession() {
        if (sessionFactory == null|| sessionFactory.isClosed()){
            sessionFactory= HibernateConfigurer.getSessionFactory();
        }
        return sessionFactory.getCurrentSession();
    }

    public void update (T entity){
        Session session = getSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    public List<T> findAll(){
        Session session = getSession();
        session.beginTransaction();
        List<T> resultList = session.createQuery("from " + persistentClass.getName(), persistentClass).getResultList();
          session.close();
          return resultList;

    }


}

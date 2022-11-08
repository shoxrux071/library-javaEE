package uz.shox.lib.dao;

import org.hibernate.Session;
import uz.shox.lib.domains.Book;
import uz.shox.lib.enums.BookStatus;
import uz.shox.lib.enums.Genre;

import java.util.List;
import java.util.Optional;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 02:15 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class BookDAO extends GenericDAO<Book,Long>{


    private static BookDAO instance = null;

    public static BookDAO getInstance(){
        if (instance == null){
            instance = new BookDAO();
        }
        return instance;
    }


    public Optional<List<Book>> findAll(String searchQuery,Integer page,Integer limit){
        Session session = getSession();
        session.beginTransaction();
        Integer skip = (page-1)*limit;

        List<Book> resultList = session.createNativeQuery("select t.* from book t  where t.status='ACTIVE' and (t.name ilike '%'||:searchQuery||'%' or t.author ilike '%'||:searchQuery||'%') order by t.id desc offset :skip limit :limit", Book.class)
                .setParameter("searchQuery", searchQuery)
                .setParameter("skip", skip)
                .setParameter("limit", limit)
                .getResultList();
        session.getTransaction().commit();
        session.close();

        return Optional.ofNullable(resultList);
    }

    public Optional<List<Book>> findAll(Genre searchQuery, Integer page, Integer limit) {
        Session session = getSession();
        session.beginTransaction();
        Integer skip = (page - 1) * limit;

        List<Book> resultList = session.createQuery("select t from Book t  where t.status=uz.shox.lib.enums.BookStatus.ACTIVE and t.genre=:genre order by t.id desc", Book.class)
                .setParameter("genre", searchQuery)
                .setFirstResult(skip)
                .setMaxResults(limit)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(resultList);
    }

    public Integer findNumberOfElementBySearch(String search) {
        Session session = getSession();
        session.beginTransaction();
        List<Book> resultList = session.createNativeQuery("select t.* from book t where t.status='ACTIVE' and (t.name ilike '%'||:searchQuery||'%' or t.author ilike '%'||:searchQuery||'%')", Book.class)
                .setParameter("searchQuery", search)
                .getResultList();
        session.getTransaction().commit();
        session.close();

        return resultList.size();
    }

    public List<Book> findAllByStatus(BookStatus pending) {
        Session session = getSession();
        session.beginTransaction();

        List<Book> resultList = session.createQuery("select t from Book t where t.status=uz.shox.lib.enums.BookStatus.PENDING", Book.class).getResultList();

        session.getTransaction().commit();
        session.close();
        return resultList;
    }

    public Integer findNumberOfElementByGenre(Genre genre) {
        Session session = getSession();
        session.beginTransaction();
        List<Book> resultList = session.createQuery("select t from Book t where t.status=uz.shox.lib.enums.BookStatus.ACTIVE and t.genre=:genre", Book.class)
                .setParameter("genre", genre)
                .getResultList();
        session.getTransaction().commit();
        session.close();

        return resultList.size();
    }

    public Book findByUploadFileId(Long uploadFileId) {
        Session session = getSession();
        session.beginTransaction();
        Book book = session.createQuery("select t from Book t where t.file.id=:uploadFileId", Book.class)
                .setParameter("uploadFileId", uploadFileId)
                .getSingleResultOrNull();
        session.getTransaction().commit();
        session.close();
        return book;
    }



}

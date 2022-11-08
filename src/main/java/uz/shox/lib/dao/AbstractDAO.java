package uz.shox.lib.dao;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 00:54 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public class AbstractDAO <D extends BaseDAO>{
    protected final D dao;

    public AbstractDAO(D dao) {
        this.dao = dao;
    }
}

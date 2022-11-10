package uz.shox.lib.service.page;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 10/11/22 00:33 (Thursday)
 * library-javaEE/IntelliJ IDEA
 */
public interface Pageable {
    Boolean hasNext(String search,Integer offset,Integer limit);
    Boolean hasPrevious(Integer offset);

    Integer totalPage(String search,Integer limit);





}

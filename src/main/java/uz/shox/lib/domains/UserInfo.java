package uz.shox.lib.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 08/11/22 00:54 (Tuesday)
 * library-javaEE/IntelliJ IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {

    private Integer number;
    private Integer totalPages;
    private Boolean hasPrevious;
    private Boolean hasNext;
}

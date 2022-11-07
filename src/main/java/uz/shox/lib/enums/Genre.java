package uz.shox.lib.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 08/11/22 00:39 (Tuesday)
 * library-javaEE/IntelliJ IDEA
 */
@AllArgsConstructor
@Getter
public enum Genre {
    CRIME("Crime"),
    HORROR("Horror"),
    CI_FI("Ci-fi"),
    DRAMA("Drama"),
    ROMANCE("Romance"),
    ROMANCE_DRAMA("Romance Drama"),
    TUTORIAL("Tutorial"),
    FANTASY("Fantasy");
    private final String key;

    public String getKey() {
        return key;
    }
}

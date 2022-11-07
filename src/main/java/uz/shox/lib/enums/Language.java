package uz.shox.lib.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 08/11/22 00:48 (Tuesday)
 * library-javaEE/IntelliJ IDEA
 */
@AllArgsConstructor
@Getter
public enum Language {
    UZ("uzbek"),RU("russian"),EN("english");
    private final String value;
}

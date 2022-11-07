package uz.shox.lib.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.shox.lib.enums.UserStatus;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 08/11/22 00:36 (Tuesday)
 * library-javaEE/IntelliJ IDEA
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String email;
    private String password;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserStatus status = UserStatus.USER;


}

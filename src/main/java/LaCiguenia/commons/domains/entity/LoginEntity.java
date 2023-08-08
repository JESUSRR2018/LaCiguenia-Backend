package LaCiguenia.commons.domains.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "login_usuario")
public class LoginEntity {
    @Id
    @Column(name = "login_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "login_email")
    private String usuarioEmail;

    @Column(name = "login_password")
    private String usuarioPassword;
}
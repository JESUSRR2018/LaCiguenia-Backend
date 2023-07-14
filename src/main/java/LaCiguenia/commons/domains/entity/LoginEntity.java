package LaCiguenia.commons.domains.entity;

import lombok.*;
import javax.persistence.*;

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

    @Column(name = "login_nombre")
    private String  usuarioNombre;

    @Column(name = "logi_email")
    private String usuarioEmail;
}
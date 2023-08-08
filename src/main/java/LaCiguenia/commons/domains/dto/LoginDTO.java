package LaCiguenia.commons.domains.dto;

import java.io.Serializable;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LoginDTO implements Serializable {

    private Integer idUsuario;
    private String usuarioEmail;
    private String usuarioPassword;
}
package LaCiguenia.commons.converter;

import LaCiguenia.commons.constans.response.ILoginResponse;
import LaCiguenia.commons.domains.dto.LoginDTO;
import LaCiguenia.commons.domains.entity.LoginEntity;
import LaCiguenia.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@Log4j2
public class LoginConverter {
    public LoginDTO convertLoginEntityToLoginDTO(LoginEntity loginEntity) {
        LoginDTO loginDTO = new LoginDTO();
        try {
            loginDTO = HelperMapper.modelMapper().map(loginEntity, LoginDTO.class);
            byte[] cadenaDecodificadaByte = Base64.getDecoder().decode(loginEntity.getUsuarioNombre());
            String cadenaDecodificada = new String(cadenaDecodificadaByte);
            loginDTO.setUsuarioNombre(cadenaDecodificada);
        } catch (Exception e) {
            log.error(ILoginResponse.DOCUMENT_FAIL + e);
        }
        return loginDTO;
    }

    public LoginEntity convertLoginDTOToLoginEntity(LoginDTO loginDTO) {
        LoginEntity loginEntity = new LoginEntity();
        try {
            loginEntity = HelperMapper.modelMapper().map(loginDTO, LoginEntity.class);
            loginEntity.setUsuarioNombre(
                    Base64.getEncoder().encodeToString(loginDTO.getUsuarioNombre().getBytes()));
        } catch (Exception e) {
            log.error(ILoginResponse.DOCUMENT_FAIL + e);
        }
        return loginEntity;
    }
}
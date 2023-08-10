package LaCiguenia.service.login;

import LaCiguenia.commons.domains.dto.login.LoginDTO;
import LaCiguenia.commons.domains.dto.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ILoginService {
    ResponseEntity<GenericResponseDTO> loginService(LoginDTO loginDTO);
    ResponseEntity<GenericResponseDTO> saveLogin(LoginDTO loginDTO);
}
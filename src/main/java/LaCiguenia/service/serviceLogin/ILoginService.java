package LaCiguenia.service.serviceLogin;

import LaCiguenia.commons.domains.dto.LoginDTO;
import LaCiguenia.commons.domains.dto.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ILoginService {
    ResponseEntity<GenericResponseDTO> loginService(LoginDTO loginDTO);
    ResponseEntity<GenericResponseDTO> saveLogin(LoginDTO loginDTO);
}
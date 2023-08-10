package LaCiguenia.webApi.loginApi;

import LaCiguenia.commons.constans.endpoints.login.ILoginEndPoint;
import LaCiguenia.commons.domains.dto.login.LoginDTO;
import LaCiguenia.commons.domains.dto.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ILoginApi {
    @PostMapping(ILoginEndPoint.LOGIN_SERVICE)
    ResponseEntity<GenericResponseDTO> loginService(@RequestBody LoginDTO loginDTO);
    @PostMapping(ILoginEndPoint.CREATE_ACOUNT)
    ResponseEntity<GenericResponseDTO> saveLogin(@RequestBody LoginDTO loginDTO);
}
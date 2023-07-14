package LaCiguenia.webApi.loginApi;

import LaCiguenia.commons.constans.endpoints.ILoginEndPoint;
import LaCiguenia.commons.domains.dto.LoginDTO;
import LaCiguenia.commons.domains.dto.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ILoginApi {
    @PostMapping(ILoginEndPoint.LOGIN)
    ResponseEntity<GenericResponseDTO> loginService(@RequestBody LoginDTO loginDTO);
    @PostMapping(ILoginEndPoint.CREATE_ACOUNT)
    ResponseEntity<GenericResponseDTO> saveLogin(@RequestBody LoginDTO loginDTO);
}
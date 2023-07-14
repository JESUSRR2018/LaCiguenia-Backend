package LaCiguenia.service.serviceLogin.implement;

import LaCiguenia.commons.constans.response.ILoginResponse;
import LaCiguenia.commons.converter.LoginConverter;
import LaCiguenia.commons.domains.dto.LoginDTO;
import LaCiguenia.commons.domains.dto.responseDTO.GenericResponseDTO;
import LaCiguenia.commons.domains.entity.LoginEntity;
import LaCiguenia.repository.ILoginRepository;
import LaCiguenia.service.serviceLogin.ILoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Log4j2
public class LoginService implements ILoginService {

    @Autowired
    private ILoginRepository iLoginRepository;
    @Autowired
    private LoginConverter loginConverter;


    @Override
    public ResponseEntity<GenericResponseDTO> loginService(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> saveLogin(LoginDTO loginDTO) {
        LoginEntity loginEntity = new LoginEntity();
        Optional<LoginEntity> existeLogin;
        try {
            existeLogin = iLoginRepository.findById(loginDTO.getIdUsuario());
            if(!existeLogin.isPresent()){
                iLoginRepository.save(loginEntity);
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message(ILoginResponse.CREATE_SUCCESS)
                        .objectResponse(ILoginResponse.CREATE_LOGIN_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message(ILoginResponse.CREATE_FAIL)
                        .objectResponse(ILoginResponse.LOGIN_SUCCESS)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            log.error(ILoginResponse.INTERNAL_SERVER + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message(ILoginResponse.CREATE_FAIL)
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
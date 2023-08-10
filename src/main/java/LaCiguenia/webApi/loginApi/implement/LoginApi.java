package LaCiguenia.webApi.loginApi.implement;


import LaCiguenia.commons.constans.endpoints.login.ILoginEndPoint;
import LaCiguenia.commons.constans.response.login.ILoginResponse;
import LaCiguenia.commons.domains.dto.login.LoginDTO;
import LaCiguenia.commons.domains.dto.responseDTO.GenericResponseDTO;
import LaCiguenia.service.login.ILoginService;
import LaCiguenia.webApi.loginApi.ILoginApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ILoginEndPoint.BASE_URL_LOGIN)
@Tag(name = "Sistema de Gestión de Usuarios", description = "Ops de autenticar, crear, eliminar y actualizar usuarios")
@Log4j2
public class LoginApi implements ILoginApi {

    private final ILoginService iLoginService;

    public LoginApi(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }

    @Override
    @Operation(summary = "controlar la autenticación de los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = ILoginResponse.AUTENTIFICATION_SUCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = ILoginResponse.AUTENTIFICACION_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = ILoginResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = ILoginResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(ILoginEndPoint.LOGIN_SERVICE)
    public ResponseEntity<GenericResponseDTO> loginService(LoginDTO loginDTO) {
        return this.iLoginService.loginService(loginDTO);
    }

    @Override
    @Operation(summary = "crear una nueva cuenta de usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = ILoginResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = ILoginResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "500", description = ILoginResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(ILoginEndPoint.CREATE_ACOUNT)
    public ResponseEntity<GenericResponseDTO> saveLogin(LoginDTO loginDTO) {
        System.out.println("Prueba Entrada " + loginDTO.getUsuarioPassword());
        return iLoginService.saveLogin(loginDTO);
    }
}
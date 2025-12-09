package br.com.gestrest.documentation;

import org.springframework.http.ResponseEntity;

import br.com.gestrest.dto.request.AuthRequestDTO;
import br.com.gestrest.dto.response.AuthResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Autenticação", description = "Login e gerenciamento JWT")
public interface AuthControllerDoc {

    @Operation(
            summary = "Realizar login e obter token JWT",
            description = "Retorna token JWT para acesso às rotas protegidas do sistema."
    )
    ResponseEntity<AuthResponseDTO> login(AuthRequestDTO dto);
}
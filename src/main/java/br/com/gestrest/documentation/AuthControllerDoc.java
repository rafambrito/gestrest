package br.com.gestrest.documentation;

import org.springframework.http.ResponseEntity;

import br.com.gestrest.dto.request.AuthRequestDTO;
import br.com.gestrest.dto.response.AuthResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Autenticação", description = "Login e gerenciamento JWT")
public interface AuthControllerDoc {

	@Operation(summary = "Realizar login", description = "Valida credenciais e retorna informações do usuário autenticado.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Autenticação realizada com sucesso", 
					content = @Content(mediaType = "application/json", 
					schema = @Schema(implementation = AuthResponseDTO.class), 
					examples = {
					@ExampleObject(name = "Login com sucesso", value = """
							{
							  "nome": "Rafael Brito",
							  "email": "rafael@email.com",
							  "tipoUsuario": "CLIENTE",
							  "token": "abc.def.ghi"
							}
							""") })),
			@ApiResponse(responseCode = "400", description = "Credenciais inválidas") })
	ResponseEntity<AuthResponseDTO> login(

			@RequestBody(required = true, description = "Credenciais de acesso", 
				content = @Content(mediaType = "application/json", 
				schema = @Schema(implementation = AuthRequestDTO.class), 
				examples = {
					@ExampleObject(name = "Exemplo de Login", value = """
							{
							  "login": "rafaelb",
							  "senha": "123456"
							}
							""") })) AuthRequestDTO dto);
}
package br.com.gestrest.documentation;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.gestrest.dto.request.TipoUsuarioRequestDTO;
import br.com.gestrest.dto.response.TipoUsuarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tipo de Usuários", description = "Documentação da API de Tipos de Usuários")
public interface TipoUsuarioControllerDoc {

	@Operation(summary = "Cadastrar novo tipo de usuário", description = "Cria um novo tipo de usuário no sistema")
	@ApiResponse(responseCode = "201", description = "Tipo de usuário criado com sucesso")
	ResponseEntity<TipoUsuarioResponseDTO> criar(
			@RequestBody(description = "Dados para criação de um novo tipo de usuário", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoUsuarioRequestDTO.class), examples = @ExampleObject(name = "Exemplo de criação tipo de usuário", value = """
					    {
					      "nome": "Dono de restaurante"
					    }
					"""))) TipoUsuarioRequestDTO dto);

	@Operation(summary = "Listar todos os tipos de usuários", description = "Retorna uma lista com todos os tipos de usuários cadastrados")
	@ApiResponse(responseCode = "200", description = "Lista de tipos de usuários retornada com sucesso")
	ResponseEntity<List<TipoUsuarioResponseDTO>> listarTodos();

	@Operation(summary = "Buscar tipo de usuário por ID", description = "Retorna os dados de um tipo de usuário específico")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Tipo de usuário encontrado"),
			@ApiResponse(responseCode = "404", description = "Tipo de usuário não encontrado") })
	ResponseEntity<TipoUsuarioResponseDTO> buscarPorId(
			@Parameter(description = "ID do tipo de usuário", example = "1") Long id);

	@Operation(summary = "Atualizar tipo de usuário", description = "Atualiza os dados de um tipo de usuário existente")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Tipo de usuário atualizado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Tipo de usuário não encontrado") })
	ResponseEntity<TipoUsuarioResponseDTO> atualizar(
			@Parameter(description = "ID do tipo de usuário", example = "1") Long id,
			@RequestBody(description = "Dados para atualização do tipo de usuário", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoUsuarioRequestDTO.class), examples = @ExampleObject(name = "Exemplo de atualização tipo de usuário", value = """
					    {
					      "nome": "Administrador"
					    }
					"""))) TipoUsuarioRequestDTO dto);
}

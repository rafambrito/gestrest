package br.com.gestrest.documentation;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.gestrest.dto.request.UsuarioRequestDTO;
import br.com.gestrest.dto.request.UsuarioSenhaRequestDTO;
import br.com.gestrest.dto.response.UsuarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuários", description = "Documentação da API de Usuários")
public interface UsuarioControllerDoc {

    @Operation(summary = "Cadastrar novo usuário")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    ResponseEntity<UsuarioResponseDTO> criar(

        @RequestBody(
            description = "Dados para criação de um novo usuário",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = UsuarioRequestDTO.class),
                examples = @ExampleObject(
                    name = "Exemplo de criação de usuário",
                    value = """
                        {
                          "nome": "Rafael Brito",
                          "email": "rafael@email.com",
                          "login": "rafaelb",
                          "senha": "123456",
                          "estado": 1,
                          "tipoUsuarioId": 2,
                          "enderecoId": 5
                        }
                    """
                )
            )
        )
        UsuarioRequestDTO dto
    );

    @Operation(summary = "Listar todos os usuários")
    ResponseEntity<List<UsuarioResponseDTO>> listarTodos();

    @Operation(summary = "Buscar usuário por ID")
    ResponseEntity<UsuarioResponseDTO> buscarPorId(
        @Parameter(description = "ID do usuário", example = "1")
        Long id
    );

    @Operation(summary = "Atualizar dados do usuário")
    ResponseEntity<UsuarioResponseDTO> atualizar(

        @Parameter(description = "ID do usuário", example = "1")
        Long id,

        @RequestBody(
            content = @Content(
                schema = @Schema(implementation = UsuarioRequestDTO.class),
                examples = @ExampleObject(
                    name = "Exemplo de atualização de usuário",
                    value = """
                        {
                          "nome": "João Atualizado",
                          "email": "joao@dominio.com",
                          "login": "joao123",
                          "estado": 2,
                          "tipoUsuarioId": 1,
                          "enderecoId": 3
                        }
                    """
                )
            )
        )
        UsuarioRequestDTO dto
    );

    @Operation(summary = "Alterar senha")
    ResponseEntity<Void> alterarSenha(
        @Parameter(description = "ID do usuário", example = "1")
        Long id,

        @RequestBody(
            content = @Content(
                schema = @Schema(implementation = UsuarioSenhaRequestDTO.class),
                examples = @ExampleObject(
                    name = "Exemplo alterar senha",
                    value = """
                        {
                          "senhaAtual": "123456",
                          "novaSenha": "999999"
                        }
                    """
                )
            )
        )
        UsuarioSenhaRequestDTO dto
    );

    @Operation(summary = "Excluir usuário")
    ResponseEntity<Void> excluir(
        @Parameter(description = "ID do usuário", example = "1")
        Long id
    );

    @Operation(summary = "Buscar usuários por nome")
    ResponseEntity<List<UsuarioResponseDTO>> buscarPorNome(
        @Parameter(description = "Filtro por nome", example = "rafa")
        String nome
    );
}

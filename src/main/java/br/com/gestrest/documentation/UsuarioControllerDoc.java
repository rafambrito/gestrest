package br.com.gestrest.documentation;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.gestrest.dto.request.UsuarioRequestDTO;
import br.com.gestrest.dto.request.UsuarioSenhaRequestDTO;
import br.com.gestrest.dto.response.UsuarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Usuários", description = "Documentação da API de Usuários")
public interface UsuarioControllerDoc {

    @Operation(summary = "Cadastrar novo usuário")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    ResponseEntity<UsuarioResponseDTO> criar(UsuarioRequestDTO dto);

    @Operation(summary = "Listar todos os usuários")
    ResponseEntity<List<UsuarioResponseDTO>> listarTodos();

    @Operation(summary = "Buscar usuário por ID")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content)
    ResponseEntity<UsuarioResponseDTO> buscarPorId(Long id);

    @Operation(summary = "Atualizar dados do usuário")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content)
    ResponseEntity<UsuarioResponseDTO> atualizar(Long id, UsuarioRequestDTO dto);

    @Operation(summary = "Alterar senha")
    ResponseEntity<Void> alterarSenha(Long id, UsuarioSenhaRequestDTO dto);

    @Operation(summary = "Excluir usuário")
    ResponseEntity<Void> excluir(Long id);

    @Operation(summary = "Buscar usuários por nome")
    ResponseEntity<List<UsuarioResponseDTO>> buscarPorNome(String nome);

}
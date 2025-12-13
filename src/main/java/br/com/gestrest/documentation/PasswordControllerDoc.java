package br.com.gestrest.documentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.gestrest.dto.request.UsuarioSenhaRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Senha", description = "Operações relacionadas à gestão de senhas")
public interface PasswordControllerDoc {

	@Operation(summary = "Alterar senha do usuário", description = "Atualiza a senha do usuário com hashing BCrypt aplicado no PasswordService.")
	@ApiResponses({ @ApiResponse(responseCode = "204", description = "Senha alterada com sucesso"),
			@ApiResponse(responseCode = "400", description = "Erro de regra de negócio"),
			@ApiResponse(responseCode = "404", description = "Usuário não encontrado") })
	ResponseEntity<Void> alterarSenha(@Parameter(description = "ID do usuário", example = "1") @PathVariable Long id,

			@RequestBody(required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioSenhaRequestDTO.class), examples = @ExampleObject(name = "Exemplo de troca de senha", value = """
					    {
					      "senhaAtual": "123456",
					      "novaSenha": "minhaSenhaNova123"
					    }
					"""))) UsuarioSenhaRequestDTO dto);
}
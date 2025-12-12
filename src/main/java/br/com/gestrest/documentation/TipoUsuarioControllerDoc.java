package br.com.gestrest.documentation;

import org.springframework.http.ResponseEntity;

import br.com.gestrest.domain.model.TipoUsuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tipo de Usuarios", description = "Documentação da API de Usuários")
public interface TipoUsuarioControllerDoc {
    @Operation(summary = "Cadastrar novo tipo de usuário")
    @ApiResponse(responseCode = "201", description = "Tipo de usuario criado com sucesso")
    ResponseEntity<TipoUsuario> criar(

        @RequestBody(
            description = "Dados para criação de um novo tipo de usuario",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TipoUsuario.class),
                examples = @ExampleObject(
                    name = "Exemplo de criação tipo de usuario",
                    value = """
                        {
                    		"nome": "Dono de restaurante"
                        }
                    """
                )
            )
        )
        TipoUsuario dto
    );
}

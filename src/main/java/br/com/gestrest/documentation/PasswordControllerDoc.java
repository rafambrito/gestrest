package br.com.gestrest.documentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.gestrest.dto.request.UsuarioSenhaRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Senha", description = "Operações relacionadas à gestão de senhas")
public interface PasswordControllerDoc {

    @Operation(summary = "Alterar senha do usuário",
               description = "Atualiza a senha do usuário com hashing BCrypt aplicado no PasswordService.")
    ResponseEntity<Void> alterarSenha(@PathVariable Long id,
                                      @RequestBody UsuarioSenhaRequestDTO dto);
}
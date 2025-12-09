package br.com.gestrest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestrest.documentation.PasswordControllerDoc;
import br.com.gestrest.dto.request.UsuarioSenhaRequestDTO;
import br.com.gestrest.service.PasswordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/password")
@RequiredArgsConstructor
public class PasswordController implements PasswordControllerDoc {

    private final PasswordService passwordService;

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Void> alterarSenha(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioSenhaRequestDTO dto) {

        passwordService.alterarSenha(id, dto);
        return ResponseEntity.noContent().build();
    }
}







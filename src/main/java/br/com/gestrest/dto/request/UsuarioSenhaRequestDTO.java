package br.com.gestrest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioSenhaRequestDTO {
    @NotBlank
    private String novaSenha;
}

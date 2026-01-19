package br.com.gestrest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank
    private String login;

    private String senha;

    @NotNull
    private Integer status;

    @NotNull
    private Long tipoUsuarioId;

    @NotNull
    private Long enderecoId;
}

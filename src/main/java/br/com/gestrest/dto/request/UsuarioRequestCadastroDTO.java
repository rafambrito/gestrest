package br.com.gestrest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestCadastroDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "Login é obrigatório.")
    private String login;

    @NotBlank(message = "Senha é obrigatória.")
    private String senha;

    @NotNull(message = "Tipo Usuário não Informado.")
    private Long tipoUsuarioId;

    @NotNull (message = "Endereço não Informado.")
    private Long enderecoId;
}

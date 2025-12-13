package br.com.gestrest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequestDTO {
	@NotBlank(message = "Login é obrigatório")
	private String login;

	@NotBlank(message = "Senha é obrigatória")
	private String senha;
}
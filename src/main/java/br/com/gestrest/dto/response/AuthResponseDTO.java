package br.com.gestrest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDTO {
	private String nome;
	private String email;
	private String tipoUsuario;
	private String token;
	private final String tokenType = "Bearer";
}
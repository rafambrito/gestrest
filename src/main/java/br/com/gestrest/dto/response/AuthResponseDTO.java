package br.com.gestrest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDTO {
	private String token;
	private final String tokenType = "Bearer";
}
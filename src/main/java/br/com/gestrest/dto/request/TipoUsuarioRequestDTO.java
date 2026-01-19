package br.com.gestrest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TipoUsuarioRequestDTO {
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(max = 45, message = "O nome deve ter no máximo 45 caracteres")
	private String nome;
}

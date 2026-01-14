package br.com.gestrest.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
	private Long id;
	private String nome;
	private String email;
	private String login;
	private Integer status;
	private String tipoUsuario;
	private String cidade;
	private String cep;
	private LocalDateTime ultimaAlteracao;
}

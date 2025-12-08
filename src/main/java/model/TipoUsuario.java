package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tipo_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tipo_usuario_id")
	private Integer tipoUsuarioId;

	@Column(name="nome_tipo")
	private String nomeTipo;
}
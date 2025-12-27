package br.com.gestrest.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StatusUsuarioEnum {

	ATIVO(1), INATIVO(2), SUSPENSO(3);

	private Integer codigoEstadoUsuario;

	StatusUsuarioEnum(int codigoEstadoUsuario) {
		this.codigoEstadoUsuario = codigoEstadoUsuario;
	}

	public Integer getCodigoEstadoUsuario() {
		return codigoEstadoUsuario;
	}

	public static String getDescricaoEstadoByCodigo(Integer codigo) {
		for (StatusUsuarioEnum estado : StatusUsuarioEnum.values()) {
			if (estado.getCodigoEstadoUsuario().equals(codigo)) {
				return estado.name();
			}
		}
		return null;
	}
}

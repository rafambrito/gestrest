package br.com.gestrest.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TipoUsuarioEnum {

	CLIENTE(1L), DONO_RESTAURANTE(2L);

	private Long codigoTipoUsuario;

	TipoUsuarioEnum(Long codigoTipoUsuario) {
		this.codigoTipoUsuario = codigoTipoUsuario;
	}

	public Long getCodigoTipoUsuario() {
		return codigoTipoUsuario;
	}
	
	public static String getDescricaoTipoByCodigo(Long id) {
		for (TipoUsuarioEnum tipo : TipoUsuarioEnum.values()) {
			if (tipo.getCodigoTipoUsuario().equals(id)) {
				return tipo.name();
			}
		}
		return null;
	}
}

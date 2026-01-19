package br.com.gestrest.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.model.TipoUsuario;
import br.com.gestrest.dto.request.TipoUsuarioRequestDTO;
import br.com.gestrest.dto.response.TipoUsuarioResponseDTO;

@Component
public class TipoUsuarioMapper {
	public TipoUsuario toEntity(TipoUsuarioRequestDTO dto) {
		TipoUsuario entity = new TipoUsuario();
		entity.setNome(dto.getNome());
		return entity;
	}

	public TipoUsuarioResponseDTO toResponse(TipoUsuario entity) {
		TipoUsuarioResponseDTO dto = new TipoUsuarioResponseDTO();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		return dto;
	}
}

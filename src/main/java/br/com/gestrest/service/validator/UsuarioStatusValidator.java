package br.com.gestrest.service.validator;

import br.com.gestrest.dto.request.UsuarioRequestDTO;
import br.com.gestrest.enums.StatusUsuarioEnum;
import br.com.gestrest.exception.RecursoNaoEncontradoException;

public class UsuarioStatusValidator implements UsuarioValidator<UsuarioRequestDTO>{

	@Override
	public void validar(UsuarioRequestDTO dto) {
		if (StatusUsuarioEnum.getDescricaoEstadoByCodigo(dto.getStatus()) == null) {
			throw new RecursoNaoEncontradoException("Status dos usuário inválido.");
		}
		
	}

}

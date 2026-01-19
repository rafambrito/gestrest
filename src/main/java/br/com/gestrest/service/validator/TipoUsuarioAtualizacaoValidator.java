package br.com.gestrest.service.validator;

import br.com.gestrest.domain.repository.TipoUsuarioRepository;
import br.com.gestrest.dto.request.UsuarioRequestDTO;

public class TipoUsuarioAtualizacaoValidator extends TipoUsuarioBaseValidator implements UsuarioValidator<UsuarioRequestDTO> {

	public TipoUsuarioAtualizacaoValidator(TipoUsuarioRepository repo) {
		super(repo);
	}
	
	@Override
	public void validar(UsuarioRequestDTO dto) {
		validarTipoUsuario(dto.getTipoUsuarioId());
	}
}
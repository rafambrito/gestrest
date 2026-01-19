package br.com.gestrest.service.validator;

import br.com.gestrest.domain.repository.TipoUsuarioRepository;
import br.com.gestrest.exception.NegocioException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TipoUsuarioBaseValidator {
	protected final TipoUsuarioRepository tipoUsuarioRepository;

    protected void validarTipoUsuario(Long tipoUsuarioId) {
        if (!tipoUsuarioRepository.existsById(tipoUsuarioId)) {
            throw new NegocioException("Tipo de usuário inválido");
        }
    }
}

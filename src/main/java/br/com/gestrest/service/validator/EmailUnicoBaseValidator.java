package br.com.gestrest.service.validator;

import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.exception.NegocioException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailUnicoBaseValidator {
	protected final UsuarioRepository usuarioRepository;

	protected void validarUnicidade(String email) {
		if (usuarioRepository.existsByEmail(email)) {
			throw new NegocioException("E-mail já cadastrado");
		}
	}
}

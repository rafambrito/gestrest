package br.com.gestrest.service.validator;

import br.com.gestrest.domain.repository.EnderecoRepository;
import br.com.gestrest.exception.NegocioException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EnderecoBaseValidator {
	protected final EnderecoRepository enderecoRepository;
	
	protected void validarEndereco(Long tipoUsuarioId) {
        if (!enderecoRepository.existsById(tipoUsuarioId)) {
        	throw new NegocioException("Endereço não encontrado.");
        }
    }
}

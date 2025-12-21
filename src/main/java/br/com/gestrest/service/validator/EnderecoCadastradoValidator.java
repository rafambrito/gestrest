package br.com.gestrest.service.validator;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.repository.EnderecoRepository;
import br.com.gestrest.exception.NegocioException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EnderecoCadastradoValidator {

    private final EnderecoRepository enderecoRepository;

    public void validar(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new NegocioException("Endereço inexistente.");
        }
    }
}
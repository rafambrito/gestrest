package br.com.gestrest.service.validator;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.exception.NegocioException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailUnicoValidator {

    private final UsuarioRepository usuarioRepository;

    public void validar(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new NegocioException("E-mail já está cadastrado");
        }
    }
}
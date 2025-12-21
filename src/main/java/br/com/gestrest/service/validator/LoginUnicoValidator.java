package br.com.gestrest.service.validator;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.exception.NegocioException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoginUnicoValidator {

    private final UsuarioRepository usuarioRepository;

    public void validar(String login) {
        if (usuarioRepository.existsByLogin(login)) {
            throw new NegocioException("Login reservado, escolha outro!");
        }
    }
}
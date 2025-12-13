package br.com.gestrest.service;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.mapper.UsuarioMapper;
import br.com.gestrest.dto.response.UsuarioResponseDTO;
import br.com.gestrest.exception.NegocioException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioLoginService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper mapper;

    public UsuarioResponseDTO login(String login, String senha) {
        Usuario usuario = usuarioRepository.findByLoginAndSenha(login, senha)
                .orElseThrow(() -> new NegocioException("Login ou senha inválidos"));

        return mapper.toResponse(usuario);
    }
}

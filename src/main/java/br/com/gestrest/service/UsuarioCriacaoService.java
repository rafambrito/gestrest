package br.com.gestrest.service;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.mapper.UsuarioMapper;
import br.com.gestrest.dto.request.UsuarioRequestDTO;
import br.com.gestrest.dto.response.UsuarioResponseDTO;
import br.com.gestrest.service.validator.EmailUnicoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioCriacaoService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper mapper;
    private final EmailUnicoValidator emailUnicoValidator;

    @Transactional
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        emailUnicoValidator.validar(dto.getEmail());

        Usuario usuario = mapper.toEntity(dto);
        usuario.atualizarDataAlteracao();

        return mapper.toResponse(usuarioRepository.save(usuario));
    }
}
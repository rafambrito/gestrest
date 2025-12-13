package br.com.gestrest.service;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.TipoUsuario;
import br.com.gestrest.domain.repository.TipoUsuarioRepository;
import br.com.gestrest.dto.mapper.TipoUsuarioMapper;
import br.com.gestrest.dto.request.TipoUsuarioRequestDTO;
import br.com.gestrest.dto.response.TipoUsuarioResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoUsuarioCriacaoService {

    private final TipoUsuarioRepository repository;
    private final TipoUsuarioMapper mapper;

    @Transactional
    public TipoUsuarioResponseDTO criar(TipoUsuarioRequestDTO dto) {
        TipoUsuario tipoUsuario = mapper.toEntity(dto);
        return mapper.toResponse(repository.save(tipoUsuario));
    }
}
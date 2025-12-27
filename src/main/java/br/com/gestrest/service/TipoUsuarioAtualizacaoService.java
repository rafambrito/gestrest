package br.com.gestrest.service;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.TipoUsuario;
import br.com.gestrest.domain.repository.TipoUsuarioRepository;
import br.com.gestrest.dto.mapper.TipoUsuarioMapper;
import br.com.gestrest.dto.request.TipoUsuarioRequestDTO;
import br.com.gestrest.dto.response.TipoUsuarioResponseDTO;
import br.com.gestrest.exception.RecursoNaoEncontradoException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoUsuarioAtualizacaoService {

    private final TipoUsuarioRepository repository;
    private final TipoUsuarioMapper mapper;

    @Transactional
    public TipoUsuarioResponseDTO atualizar(Long id, TipoUsuarioRequestDTO dto) {
        TipoUsuario tipoUsuario = repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Tipo de Usuário não encontrado com id: " + id));

        tipoUsuario.setNome(dto.getNome());

        return mapper.toResponse(repository.save(tipoUsuario));
    }
}

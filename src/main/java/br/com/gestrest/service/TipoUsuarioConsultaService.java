package br.com.gestrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.TipoUsuario;
import br.com.gestrest.domain.repository.TipoUsuarioRepository;
import br.com.gestrest.dto.mapper.TipoUsuarioMapper;
import br.com.gestrest.dto.response.TipoUsuarioResponseDTO;
import br.com.gestrest.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoUsuarioConsultaService {

	private final TipoUsuarioRepository repository;
	private final TipoUsuarioMapper mapper;

	public List<TipoUsuarioResponseDTO> listarTodos() {
		return repository.findAll().stream().map(mapper::toResponse).toList();
	}

	public TipoUsuarioResponseDTO buscarPorId(Long id) {
		TipoUsuario tipoUsuario = repository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Tipo de Usuário não encontrado com id: " + id));

		return mapper.toResponse(tipoUsuario);
	}
}
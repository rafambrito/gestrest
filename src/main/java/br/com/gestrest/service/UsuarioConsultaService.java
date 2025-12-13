package br.com.gestrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.mapper.UsuarioMapper;
import br.com.gestrest.dto.response.UsuarioResponseDTO;
import br.com.gestrest.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioConsultaService {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper mapper;

	public UsuarioResponseDTO buscarPorId(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com id: " + id));
		return mapper.toResponse(usuario);
	}

	public List<UsuarioResponseDTO> listarTodos() {
		return usuarioRepository.findAll().stream().map(mapper::toResponse).toList();
	}

	public List<UsuarioResponseDTO> buscarPorNome(String nome) {
		return usuarioRepository.findByNomeContainingIgnoreCase(nome).stream().map(mapper::toResponse).toList();
	}
}
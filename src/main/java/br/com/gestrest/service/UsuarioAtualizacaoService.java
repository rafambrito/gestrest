package br.com.gestrest.service;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.mapper.UsuarioMapper;
import br.com.gestrest.dto.request.UsuarioRequestDTO;
import br.com.gestrest.dto.response.UsuarioResponseDTO;
import br.com.gestrest.exception.RecursoNaoEncontradoException;
import br.com.gestrest.service.validator.EmailUnicoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioAtualizacaoService {

	private final UsuarioRepository usuarioRepository;
	private final EmailUnicoValidator emailUnicoValidator;
	private final UsuarioMapper mapper;

	@Transactional
	public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
		Usuario usuario = obterUsuario(id);

		if (!usuario.getEmail().equals(dto.getEmail())) {
			emailUnicoValidator.validar(dto.getEmail());
		}

		usuario.atualizarDados(dto);
		usuario.atualizarDataAlteracao();

		return mapper.toResponse(usuarioRepository.save(usuario));
	}

	private Usuario obterUsuario(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com id: " + id));
	}
}
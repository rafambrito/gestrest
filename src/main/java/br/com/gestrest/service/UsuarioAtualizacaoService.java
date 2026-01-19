package br.com.gestrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.mapper.UsuarioMapper;
import br.com.gestrest.dto.request.UsuarioRequestDTO;
import br.com.gestrest.dto.response.UsuarioResponseDTO;
import br.com.gestrest.exception.RecursoNaoEncontradoException;
import br.com.gestrest.service.validator.EmailUnicoAtualizacaoValidator;
import br.com.gestrest.service.validator.UsuarioValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioAtualizacaoService {

	private final UsuarioRepository usuarioRepository;
	private final EmailUnicoAtualizacaoValidator emailUnicoValidator;
	private final UsuarioMapper mapper;
	
	private final List<UsuarioValidator<UsuarioRequestDTO>> validators;
	
	@Transactional
	public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
		Usuario usuario = obterUsuario(id);

		validators.forEach(v -> v.validar(dto));
		
		emailUnicoValidator.validarAlteracao(usuario, dto);		
	
		usuario.atualizarDados(dto);
		usuario.atualizarDataAlteracao();

		return mapper.toResponse(usuarioRepository.save(usuario));
	}

	private Usuario obterUsuario(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com id: " + id));
	}
}
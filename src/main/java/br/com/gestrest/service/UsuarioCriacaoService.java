package br.com.gestrest.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.mapper.UsuarioMapper;
import br.com.gestrest.dto.request.UsuarioRequestCadastroDTO;
import br.com.gestrest.dto.response.UsuarioResponseDTO;
import br.com.gestrest.service.validator.UsuarioValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioCriacaoService {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper mapper;
	private final PasswordEncoder passwordEncoder;
	
	private final List<UsuarioValidator<UsuarioRequestCadastroDTO>> validators;
	
	@Transactional
	public UsuarioResponseDTO criar(UsuarioRequestCadastroDTO dto) {	
		validators.forEach(v -> v.validar(dto));
		
		Usuario usuario = mapper.toEntityCadastro(dto);
		usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
		usuario.atualizarDataAlteracao();

		return mapper.toResponse(usuarioRepository.save(usuario));
	}
}
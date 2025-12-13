package br.com.gestrest.service;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.request.UsuarioSenhaRequestDTO;
import br.com.gestrest.exception.RecursoNaoEncontradoException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioSenhaService {

	private final UsuarioRepository usuarioRepository;

	@Transactional
	public void alterarSenha(Long id, UsuarioSenhaRequestDTO dto) {
		Usuario usuario = obterUsuario(id);
		usuario.alterarSenha(dto.getNovaSenha());
		usuario.atualizarDataAlteracao();
		usuarioRepository.save(usuario);
	}

	private Usuario obterUsuario(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));
	}
}
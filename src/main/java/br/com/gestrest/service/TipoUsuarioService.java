package br.com.gestrest.service;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.TipoUsuario;
import br.com.gestrest.domain.repository.TipoUsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoUsuarioService {
	
	private final TipoUsuarioRepository tipoUsuarioRepository;
	
	public TipoUsuario salvar(TipoUsuario tipoUsuario) {
		return tipoUsuarioRepository.save(tipoUsuario);
	}
	
}

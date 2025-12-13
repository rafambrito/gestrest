package br.com.gestrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gestrest.dto.request.TipoUsuarioRequestDTO;
import br.com.gestrest.dto.response.TipoUsuarioResponseDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoUsuarioService {

	private final TipoUsuarioCriacaoService criacaoService;
	private final TipoUsuarioConsultaService consultaService;
	private final TipoUsuarioAtualizacaoService atualizacaoService;

	public TipoUsuarioResponseDTO criar(TipoUsuarioRequestDTO dto) {
		return criacaoService.criar(dto);
	}

	public List<TipoUsuarioResponseDTO> listarTodos() {
		return consultaService.listarTodos();
	}

	public TipoUsuarioResponseDTO buscarPorId(Long id) {
		return consultaService.buscarPorId(id);
	}

	public TipoUsuarioResponseDTO atualizar(Long id, TipoUsuarioRequestDTO dto) {
		return atualizacaoService.atualizar(id, dto);
	}
}

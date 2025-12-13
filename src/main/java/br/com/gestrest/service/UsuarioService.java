package br.com.gestrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gestrest.dto.request.UsuarioRequestDTO;
import br.com.gestrest.dto.request.UsuarioSenhaRequestDTO;
import br.com.gestrest.dto.response.UsuarioResponseDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioCriacaoService criacaoService;
	private final UsuarioAtualizacaoService atualizacaoService;
	private final UsuarioSenhaService senhaService;
	private final UsuarioLoginService loginService;
	private final UsuarioConsultaService consultaService;
	private final UsuarioExclusaoService exclusaoService;

	public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
		return criacaoService.criar(dto);
	}

	public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
		return atualizacaoService.atualizar(id, dto);
	}

	public void alterarSenha(Long id, UsuarioSenhaRequestDTO dto) {
		senhaService.alterarSenha(id, dto);
	}

	public UsuarioResponseDTO login(String login, String senha) {
		return loginService.login(login, senha);
	}

	public UsuarioResponseDTO buscarPorId(Long id) {
		return consultaService.buscarPorId(id);
	}

	public List<UsuarioResponseDTO> listarTodos() {
		return consultaService.listarTodos();
	}

	public List<UsuarioResponseDTO> buscarPorNome(String nome) {
		return consultaService.buscarPorNome(nome);
	}

	public void excluir(Long id) {
		exclusaoService.excluir(id);
	}
}

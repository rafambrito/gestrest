package br.com.gestrest.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.model.Endereco;
import br.com.gestrest.domain.model.TipoUsuario;
import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.dto.request.UsuarioRequestDTO;
import br.com.gestrest.dto.response.UsuarioResponseDTO;

@Component
public class UsuarioMapper {

	public Usuario toEntity(UsuarioRequestDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setLogin(dto.getLogin());
		usuario.setSenha(dto.getSenha());
		usuario.setEstado(dto.getEstado());

		TipoUsuario tipo = new TipoUsuario();
		tipo.setId(dto.getTipoUsuarioId());
		usuario.setTipoUsuario(tipo);

		Endereco end = new Endereco();
		end.setId(dto.getEnderecoId());
		usuario.setEndereco(end);

		return usuario;
	}

	public UsuarioResponseDTO toResponse(Usuario usuario) {
		UsuarioResponseDTO dto = new UsuarioResponseDTO();
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		dto.setEmail(usuario.getEmail());
		dto.setLogin(usuario.getLogin());
		dto.setEstado(usuario.getEstado());
		dto.setUltimaAlteracao(usuario.getDataUltimaAlteracao());

		dto.setTipoUsuario(usuario.getTipoUsuario().getNome());
		dto.setCidade(usuario.getEndereco().getCidade());
		dto.setCep(usuario.getEndereco().getCep());

		return dto;
	}
}

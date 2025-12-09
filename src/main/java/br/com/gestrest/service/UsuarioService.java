package br.com.gestrest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.UsuarioMapper;
import br.com.gestrest.dto.request.UsuarioRequestDTO;
import br.com.gestrest.dto.request.UsuarioSenhaRequestDTO;
import br.com.gestrest.dto.response.UsuarioResponseDTO;
import br.com.gestrest.exception.NegocioException;
import br.com.gestrest.exception.RecursoNaoEncontradoException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper mapper;

    @Transactional
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        validarEmailUnico(dto.getEmail());

        Usuario usuario = mapper.toEntity(dto);
        usuario.setDataUltimaAlteracao(LocalDateTime.now());

        return mapper.toResponse(usuarioRepository.save(usuario));
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = obterUsuario(id);
        return mapper.toResponse(usuario);
    }

    @Transactional
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = obterUsuario(id);

        if (!usuario.getEmail().equals(dto.getEmail())) {
            validarEmailUnico(dto.getEmail());
        }

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setLogin(dto.getLogin());
        usuario.setEstado(dto.getEstado());
        usuario.setTipoUsuario(usuario.getTipoUsuario());
        usuario.setEndereco(usuario.getEndereco());
        usuario.setDataUltimaAlteracao(LocalDateTime.now());

        return mapper.toResponse(usuarioRepository.save(usuario));
    }

    @Transactional
    public void alterarSenha(Long id, UsuarioSenhaRequestDTO dto) {
        Usuario usuario = obterUsuario(id);
        usuario.setSenha(dto.getNovaSenha());
        usuario.setDataUltimaAlteracao(LocalDateTime.now());
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void excluir(Long id) {
        Usuario usuario = obterUsuario(id);
        usuarioRepository.delete(usuario);
    }

    public UsuarioResponseDTO login(String login, String senha) {
        Usuario usuario = usuarioRepository.findByLoginAndSenha(login, senha)
                .orElseThrow(() -> new NegocioException("Login ou senha inválidos"));

        return mapper.toResponse(usuario);
    }


    public List<UsuarioResponseDTO> buscarPorNome(String nome) {
        return usuarioRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }


    private Usuario obterUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Usuário não encontrado com id: " + id));
    }

    private void validarEmailUnico(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new NegocioException("E-mail já está cadastrado");
        }
    }
}

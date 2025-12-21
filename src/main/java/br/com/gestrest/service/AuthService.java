package br.com.gestrest.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.request.AuthRequestDTO;
import br.com.gestrest.dto.response.AuthResponseDTO;
import br.com.gestrest.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;
	private final UsuarioRepository usuarioRepository;

	public AuthResponseDTO autenticar(AuthRequestDTO dto) {

		// Autentica usuário usando UserDetailsService + BCrypt internamente
		Authentication autenticado = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getLogin(),
						dto.getSenha()));

		String token = jwtTokenProvider.generateToken(autenticado.getName());
		Usuario usuario = usuarioRepository.findByLogin(autenticado.getName())
				.orElseThrow();

		return new AuthResponseDTO(usuario.getNome(), usuario.getEmail(),
				usuario.getTipoUsuario().getNome(), token);
	}
}
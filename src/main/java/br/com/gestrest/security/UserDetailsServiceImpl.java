package br.com.gestrest.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        String role = usuario.getTipoUsuario() != null ? usuario.getTipoUsuario().getNome() : "USER";
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.toUpperCase());

        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .authorities(List.of(authority)) 
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(usuario.getStatus() != 1)
                .build();
    }
}
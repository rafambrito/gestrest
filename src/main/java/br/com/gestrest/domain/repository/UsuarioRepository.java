package br.com.gestrest.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestrest.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	boolean existsByEmail(String email);

	// Login simples (antes de implementar segurança com password hash)
	Optional<Usuario> findByLoginAndSenha(String login, String senha);

	List<Usuario> findByNomeContainingIgnoreCase(String nome);

	Optional<Usuario> findByLogin(String login);

	boolean existsByLogin(String login);
}

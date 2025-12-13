package br.com.gestrest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestrest.domain.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

}

package br.com.gestrest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestrest.domain.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	boolean existsById(Long id);
}

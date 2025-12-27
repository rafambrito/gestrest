package br.com.gestrest.service.validator;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.model.Usuario;
import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.request.UsuarioRequestDTO;

@Component
public class EmailUnicoAtualizacaoValidator extends EmailUnicoBaseValidator {
	public EmailUnicoAtualizacaoValidator(UsuarioRepository repo) {
        super(repo);
    }

    public void validarAlteracao(Usuario usuario, UsuarioRequestDTO dto) {
        if (!usuario.getEmail().equals(dto.getEmail())) {
            validarUnicidade(dto.getEmail());
        }
    }
}

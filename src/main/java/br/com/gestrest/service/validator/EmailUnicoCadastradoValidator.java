package br.com.gestrest.service.validator;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.request.UsuarioRequestCadastroDTO;

@Component
public class EmailUnicoCadastradoValidator extends EmailUnicoBaseValidator implements UsuarioValidator<UsuarioRequestCadastroDTO> {

	public EmailUnicoCadastradoValidator(UsuarioRepository repo) {
        super(repo);
    }

    @Override
    public void validar(UsuarioRequestCadastroDTO dto) {
        validarUnicidade(dto.getEmail());
    }
}
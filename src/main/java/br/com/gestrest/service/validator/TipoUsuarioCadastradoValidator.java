package br.com.gestrest.service.validator;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.repository.TipoUsuarioRepository;
import br.com.gestrest.dto.request.UsuarioRequestCadastroDTO;

@Component
public class TipoUsuarioCadastradoValidator extends TipoUsuarioBaseValidator implements UsuarioValidator<UsuarioRequestCadastroDTO> {
	
    public TipoUsuarioCadastradoValidator(TipoUsuarioRepository repo) {
        super(repo);
    }

    @Override
    public void validar(UsuarioRequestCadastroDTO dto) {
        validarTipoUsuario(dto.getTipoUsuarioId());
    }
}

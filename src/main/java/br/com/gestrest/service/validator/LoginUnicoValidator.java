package br.com.gestrest.service.validator;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.repository.UsuarioRepository;
import br.com.gestrest.dto.request.UsuarioRequestCadastroDTO;
import br.com.gestrest.exception.NegocioException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoginUnicoValidator implements UsuarioValidator<UsuarioRequestCadastroDTO> {

    private final UsuarioRepository usuarioRepository;

	@Override
	public void validar(UsuarioRequestCadastroDTO dto) {
		if (usuarioRepository.existsByLogin(dto.getLogin())) {
            throw new NegocioException("Login reservado, escolha outro!");
        }		
	}
}
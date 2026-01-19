package br.com.gestrest.service.validator;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.repository.EnderecoRepository;
import br.com.gestrest.dto.request.UsuarioRequestCadastroDTO;

@Component
public class EnderecoCadastradoValidator extends EnderecoBaseValidator implements UsuarioValidator<UsuarioRequestCadastroDTO> {

	public EnderecoCadastradoValidator(EnderecoRepository repo) {
		super(repo);
	}

	@Override
	public void validar(UsuarioRequestCadastroDTO dto) {
		validarEndereco(dto.getEnderecoId());
	}
}
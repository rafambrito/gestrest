package br.com.gestrest.service.validator;

import org.springframework.stereotype.Component;

import br.com.gestrest.domain.repository.EnderecoRepository;
import br.com.gestrest.dto.request.UsuarioRequestDTO;


@Component
public class EnderecoCadastradoAtualizacaoValidator extends EnderecoBaseValidator implements UsuarioValidator<UsuarioRequestDTO> {
	public EnderecoCadastradoAtualizacaoValidator(EnderecoRepository repo) {
		super(repo);
	}

	@Override
	public void validar(UsuarioRequestDTO dto) {
		validarEndereco(dto.getEnderecoId());
	}
}

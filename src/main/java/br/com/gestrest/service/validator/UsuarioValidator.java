package br.com.gestrest.service.validator;

public interface UsuarioValidator<T> {
	void validar(T dto);
}

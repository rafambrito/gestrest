package br.com.gestrest.exception;

import java.net.URI;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE) 
@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ProblemDetail handleRecursoNaoEncontrado(RecursoNaoEncontradoException e) {

		ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problem.setTitle("Recurso não encontrado");
		problem.setType(URI.create("/errors/recurso-nao-encontrado"));

		return problem;
	}

	@ExceptionHandler(NegocioException.class)
	public ProblemDetail handleNegocio(NegocioException e) {

		ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
		problem.setTitle("Violação de regra de negócio");
		problem.setType(URI.create("/errors/regra-de-negocio"));

		return problem;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleValidacao(MethodArgumentNotValidException e) {

		ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Campos inválidos");
		problem.setTitle("Erro de validação");
		problem.setType(URI.create("/errors/validacao"));

		var errors = e.getBindingResult().getFieldErrors().stream().collect(
				java.util.stream.Collectors.toMap(field -> field.getField(), field -> field.getDefaultMessage()));

		problem.setProperty("erros", errors);
		return problem;
	}

	@ExceptionHandler(Exception.class)
	public ProblemDetail handleErroGeral(Exception e) {

		ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				"Erro inesperado. Contate o suporte.");

		problem.setTitle("Erro interno no servidor");
		problem.setType(URI.create("/errors/erro-interno"));

		return problem;
	}
}

package br.com.gestrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestrest.documentation.TipoUsuarioControllerDoc;
import br.com.gestrest.domain.model.TipoUsuario;
import br.com.gestrest.service.TipoUsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tipoUsuario")
@RequiredArgsConstructor
public class TipoUsuarioController implements TipoUsuarioControllerDoc {
	
	private final TipoUsuarioService service;
	
	@Override
	@PostMapping
	public ResponseEntity<TipoUsuario> criar(@RequestBody TipoUsuario dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
	}

}

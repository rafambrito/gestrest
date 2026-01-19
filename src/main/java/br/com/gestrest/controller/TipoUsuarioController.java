package br.com.gestrest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestrest.documentation.TipoUsuarioControllerDoc;
import br.com.gestrest.dto.request.TipoUsuarioRequestDTO;
import br.com.gestrest.dto.response.TipoUsuarioResponseDTO;
import br.com.gestrest.service.TipoUsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tipos-usuarios")
@RequiredArgsConstructor
public class TipoUsuarioController implements TipoUsuarioControllerDoc {

	private final TipoUsuarioService service;

	@Override
	@PostMapping
	public ResponseEntity<TipoUsuarioResponseDTO> criar(@RequestBody TipoUsuarioRequestDTO dto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<TipoUsuarioResponseDTO>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<TipoUsuarioResponseDTO> buscarPorId(@PathVariable Long id) {

		return ResponseEntity.ok(service.buscarPorId(id));
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<TipoUsuarioResponseDTO> atualizar(@PathVariable Long id,
			@RequestBody TipoUsuarioRequestDTO dto) {

		return ResponseEntity.ok(service.atualizar(id, dto));
	}
}
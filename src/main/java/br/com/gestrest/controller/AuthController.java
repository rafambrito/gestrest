package br.com.gestrest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestrest.documentation.AuthControllerDoc;
import br.com.gestrest.dto.request.AuthRequestDTO;
import br.com.gestrest.dto.response.AuthResponseDTO;
import br.com.gestrest.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController implements AuthControllerDoc {

	private final AuthService authService;

	@Override
	@PostMapping("/login")
	public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody AuthRequestDTO dto) {
		return ResponseEntity.ok(authService.autenticar(dto));
	}
}
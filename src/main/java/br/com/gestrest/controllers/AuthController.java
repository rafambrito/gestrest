package br.com.gestrest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestrest.dto.LoginRequest;
import br.com.gestrest.dto.LoginResponse;
import br.com.gestrest.security.JwtTokenService;
import br.com.gestrest.services.UserService;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final UserService userService;
    private final JwtTokenService jwtTokenService;

    public AuthController(UserService userService, JwtTokenService jwtTokenService) {
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        logger.info("POST -> /v1/auth/login for user {}", request.getLogin());
        try {
            var user = userService.login(request.getLogin(), request.getSenha());
            var token = jwtTokenService.generateToken(user);
            var response = new LoginResponse(
                    user.getUsuarioId(),
                    user.getNome(),
                    user.getEmail(),
                    user.getLogin(),
                    user.getTipoUsuarioId(),
                    token);
            return ResponseEntity.ok(response);
        } 
        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}

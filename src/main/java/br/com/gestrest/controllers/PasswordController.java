package br.com.gestrest.controllers;

import br.com.gestrest.dto.PasswordUpdateDTO;
import br.com.gestrest.services.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/v1/changePassword")
public class PasswordController {

    private static final Logger logger = LoggerFactory.getLogger(PasswordController.class);

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable("id") Long id, @RequestBody PasswordUpdateDTO request) {

        this.passwordService.updatePassword(id, request.getSenha());
        return ResponseEntity.ok().build();
    }
}

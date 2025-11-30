package br.com.gestrest.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestrest.entities.User;
import br.com.gestrest.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/users")
@Tag(name = "Users", description = "Gerencia operações de usuários")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os usuários", description = "Retorna todos os usuários cadastrados no sistema")
    public ResponseEntity<List<User>> findAllUsers(
        @RequestParam("page") int page,
        @RequestParam("size") int size
    ) {
        logger.info("/users");
        var users = this.userService.findAllUsers(page, size);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca usuário por ID", description = "Retorna os detalhes de um usuário específico pelo seu ID")
    public ResponseEntity<Optional<User>> findUser(
        @PathVariable("id") Long id
    ) {
        logger.info("/users/" + id);
        var user = this.userService.findUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    @Operation(summary = "Cria um novo usuário", description = "Adiciona um usuário no sistema")
    public ResponseEntity<Void> createUser(
        @RequestBody User user
    ) {
        logger.info("POST ->  /users");
        this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza usuário existente", description = "Atualiza os dados de um usuário pelo ID")
    public ResponseEntity<Void> updateUser(
        @PathVariable("id") Long id,
        @RequestBody User oldUser
    ) {
        logger.info("PUT ->  /users");
        this.userService.updateUser(oldUser, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove usuário", description = "Deleta um usuário pelo seu ID")
    public ResponseEntity<Void> deleteUser(
        @PathVariable("id") Long id
    ) {
        logger.info("DELETE ->  /users/" + id);
        this.userService.delteUser(id);
        return ResponseEntity.ok().build();
    }
}

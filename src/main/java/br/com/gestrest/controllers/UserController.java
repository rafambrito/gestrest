package br.com.gestrest.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String getUsers() {
        logger.info("Listing users");
        return "Hello Users";
    }

    //http://localhost:8080/v1/users/1
    //http://localhost:8080/v1/users?page=1&size=10
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(
        @RequestParam("page") int page,
        @RequestParam("size") int size
    ) {
        logger.info("/users");
        var users = this.userService.findAllUsers(page, size);
        return ResponseEntity.ok(users);
    }

    //http://localhost:8080/v1/users/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUser(
        @PathVariable("id") Long id
    ) {
        logger.info("/users/" + id);
        var user = this.userService.findUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(
        @RequestBody User user
    ) {
        logger.info("POST ->  /users");
        this.userService.saveUser(user);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(
        @PathVariable("id") Long id,
        @RequestBody User oldUser
    ) {
        logger.info("PUT ->  /users");
        this.userService.updateUser(oldUser, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
        @PathVariable("id") Long id
    ) {
        logger.info("DELETE ->  /users/" + id);
        this.userService.delteUser(id);
        return ResponseEntity.ok().build();
    }
}

package br.com.gestrest.repositories;

import java.util.List;
import java.util.Optional;

import br.com.gestrest.entities.User;

public interface UserRepository {

    Optional<User> findById(Long id);
    List<User> findAll(int size, int offset);
    Integer save(User newUser);
    Integer update(User oldUser, Long id);
    Integer delete(Long id);
}

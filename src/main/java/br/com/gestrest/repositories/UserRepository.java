package br.com.gestrest.repositories;

import java.util.List;
import java.util.Optional;

import br.com.gestrest.entities.User;

public interface UserRepository {

    Optional<User> findById(Long id);
    List<User> findAll(int size, int offset);
    Optional<User> findByLogin(String login);
    Integer save(User newUser);
    Integer update(User oldUser, Long id);
    Integer updatePassword(Long id, String senha);
    Integer delete(Long id);
}

package br.com.gestrest.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import br.com.gestrest.entities.User;

@Repository
public class UserRepositoryImp implements UserRepository {

    private final JdbcClient jdbcClient;

    public UserRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.jdbcClient
            .sql("SELECT id, name, email, password, profile, username FROM users WHERE id = :id")
            .param("id", id)
            .query(User.class)
            .optional();
    }

    @Override
    public List<User> findAll(int size, int offset) {
        return this.jdbcClient
            .sql("SELECT id, name, email, password, profile, username FROM users ORDER BY id LIMIT :size OFFSET :offset")
            .param("size", size)
            .param("offset", offset)
            .query(User.class)
            .list();
    }

    @Override
    public Integer save(User newUser) {
        return this.jdbcClient
            .sql("INSERT INTO users (name, email, password, profile, username) VALUES (:name, :email, :password, :profile, :username)")
            .param("name", newUser.getName())
            .param("email", newUser.getEmail())
            .param("password", newUser.getPassword())
            .param("profile", newUser.getProfile())
            .param("username", newUser.getUsername())
            .update();
    }

    @Override
    public Integer update(User oldUser, Long id) {
        return this.jdbcClient
            .sql("UPDATE users SET name = :name, email = :email, password = :password, profile = :profile, username = :username WHERE id = :id")
            .param("id", id)
            .param("name", oldUser.getName())
            .param("email", oldUser.getEmail())
            .param("password", oldUser.getPassword())
            .param("profile", oldUser.getProfile())
            .param("username", oldUser.getUsername())
            .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
            .sql("DELETE FROM users WHERE id = :id")
            .param("id", id)
            .update();
    }

}

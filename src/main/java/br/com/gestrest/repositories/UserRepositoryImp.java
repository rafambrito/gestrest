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
            .sql("SELECT * FROM User WHERE Id = :id")
            .param("id", id)
            .query(User.class)
            .optional();
    }

    @Override
    public List<User> findAll(int size, int offset) {
        return this.jdbcClient
            .sql("SELECT * FROM User WHERE LIMIT = :size OFFSET = :offset")
            .param("size", size)
            .param("offset", offset)
            .query(User.class)
            .list();
    }

    @Override
    public Integer save(User newUser) {
        return this.jdbcClient
            .sql("INSERT INTO User (Name, Email, Password, Profile, Username) VALUES (:Name, :Email, :Password, :Profile, :Username) ")
            .param("Name", newUser.getName())
            .param("Email", newUser.getEmail())
            .param("Password", newUser.getPassword())
            .param("Profile", newUser.getProfile())
            .param("Username", newUser.getUsername())
            .update();
    }

    @Override
    public Integer update(User oldUser, Long id) {
        return this.jdbcClient
            .sql("UPDATE User SET Name = :Name, Email = :Email, Password = :Password, Profile =:Profile, Username = :Username WHERE Id = :id")
            .param("Id", id)
            .param("Name", oldUser.getName())
            .param("Email", oldUser.getEmail())
            .param("Password", oldUser.getPassword())
            .param("Profile", oldUser.getProfile())
            .param("Username", oldUser.getUsername())
            .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
            .sql("DELETE FROM User WHERE Id = :id")
            .param("Id", id)
            .update();
    }

}

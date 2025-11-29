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
            .sql("""
                    SELECT
                        usuario_id,
                        nome,
                        email,
                        login,
                        senha,
                        estado,
                        tipo_usuario_id,
                        endereco_id,
                        data_ultima_alteracao
                    FROM gestrest.usuario
                    WHERE usuario_id = :id
                  """)
            .param("id", id)
            .query(User.class)
            .optional();
    }

    @Override
    public List<User> findAll(int size, int offset) {
        return this.jdbcClient
            .sql("""
                    SELECT
                        usuario_id,
                        nome,
                        email,
                        login,
                        senha,
                        estado,
                        tipo_usuario_id,
                        endereco_id,
                        data_ultima_alteracao
                    FROM gestrest.usuario
                    ORDER BY usuario_id
                    LIMIT :size OFFSET :offset
                  """)
            .param("size", size)
            .param("offset", offset)
            .query(User.class)
            .list();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return this.jdbcClient
            .sql("""
                    SELECT
                        usuario_id,
                        nome,
                        email,
                        login,
                        senha,
                        estado,
                        tipo_usuario_id,
                        endereco_id,
                        data_ultima_alteracao
                    FROM gestrest.usuario
                    WHERE login = :login
                  """)
            .param("login", login)
            .query(User.class)
            .optional();
    }

    @Override
    public Integer save(User newUser) {
        return this.jdbcClient
            .sql("INSERT INTO gestrest.usuario (nome, email, login, senha) VALUES (:nome, :email, :login, :senha)")
            .param("nome", newUser.getNome())
            .param("email", newUser.getEmail())
            .param("login", newUser.getLogin())
            .param("senha", newUser.getSenha())
            .update();
    }

    @Override
    public Integer update(User oldUser, Long id) {
        return this.jdbcClient
            .sql("UPDATE gestrest.usuario SET nome = :nome, email = :email, login = :login, senha = :senha WHERE usuario_id = :id")
            .param("id", id)
            .param("nome", oldUser.getNome())
            .param("email", oldUser.getEmail())
            .param("login", oldUser.getLogin())
            .param("senha", oldUser.getSenha())
            .update();
    }

    @Override
    public Integer updatePassword(Long id, String senha) {
        return this.jdbcClient
            .sql("UPDATE gestrest.usuario SET senha = :senha, data_ultima_alteracao = CURRENT_TIMESTAMP WHERE usuario_id = :id")
            .param("id", id)
            .param("senha", senha)
            .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
            .sql("DELETE FROM gestrest.usuario WHERE usuario_id = :id")
            .param("id", id)
            .update();
    }

}

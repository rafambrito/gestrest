package br.com.gestrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.gestrest.entities.User;
import br.com.gestrest.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAllUsers(int page, int size) {
        int offset = (page - 1) * size;
        return this.userRepository.findAll(size, offset);
    }

    public Optional<User> findUser(Long id) {
        return this.userRepository.findById(id);
    }

    public void saveUser(User newUser) {
        newUser.setSenha(passwordEncoder.encode(newUser.getSenha()));

        var save = this.userRepository.save(newUser);
        Assert.state(save == 1, "Error saving user " + newUser.getNome());
    }

    public void updateUser(User oldUser, Long id) {
        oldUser.setSenha(passwordEncoder.encode(oldUser.getSenha()));

        var update = this.userRepository.update(oldUser, id);
        if (update == 0) {
            throw new RuntimeException("User not found");
        }
    }

    public void delteUser(Long id) {
        var delete = this.userRepository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("User not found");
        }
    }
}

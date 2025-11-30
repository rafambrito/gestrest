package br.com.gestrest.services;

import br.com.gestrest.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public PasswordService(UserRepository userRepository, PasswordEncoder passwordENcoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordENcoder;
    }

    @Transactional
    public void updatePassword(Long userId, String password) {
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        }

        String passwordHash = passwordEncoder.encode(password);

        Integer rowsAffected = userRepository.updatePassword(userId, passwordHash);

        if (rowsAffected == 0) {
            throw new RuntimeException("Usuário com ID: %s, não foi encontrado" + userId);
        }
    }
}

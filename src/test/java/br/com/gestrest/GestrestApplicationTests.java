package br.com.gestrest;

import br.com.gestrest.dto.LoginRequest;
import br.com.gestrest.dto.PasswordUpdateDTO;
import br.com.gestrest.entities.User;
import br.com.gestrest.security.JwtTokenService;
import br.com.gestrest.services.PasswordService;
import br.com.gestrest.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = "gestrest.jwt.secret=ChaveSecretaMuitoLongaParaTestesUnitarios123456")
class GestrestApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtTokenService jwtTokenService;

    @MockBean
    private UserService userService;

    @MockBean
    private PasswordService passwordService;

    private User mockUser;
    private String validToken;

    @BeforeEach
    void setUp() {
        mockUser = new User();
        mockUser.setUsuarioId(1L);
        mockUser.setNome("Teste User");
        mockUser.setEmail("teste@gestrest.com");
        mockUser.setLogin("testeuser");
        mockUser.setSenha("senha123");
        mockUser.setTipoUsuarioId(1);
        mockUser.setEstado(1);
        mockUser.setDataUltimaAlteracao(LocalDateTime.now());

        validToken = "Bearer " + jwtTokenService.generateToken(mockUser);
    }

    // Conjuntos de teste para o AuthController
    @Nested
    @DisplayName("Testes do AuthController")
    class AuthControllerTests {

        @Test
        @DisplayName("POST /v1/auth/login - Deve realizar login com sucesso")
        void testLoginSuccess() throws Exception {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setLogin("testeuser");
            loginRequest.setSenha("senha123");

            given(userService.login("testeuser", "senha123")).willReturn(mockUser);

            mockMvc.perform(post("/v1/auth/login")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(loginRequest)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.token").exists())
                    .andExpect(jsonPath("$.login").value("testeuser"));
        }

        @Test
        @DisplayName("POST /v1/auth/login - Deve falhar com credenciais inválidas")
        void testLoginFailure() throws Exception {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setLogin("invalido");
            loginRequest.setSenha("errada");

            given(userService.login("invalido", "errada"))
                    .willThrow(new RuntimeException("Invalid credentials"));

            mockMvc.perform(post("/v1/auth/login")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(loginRequest)))
                    .andExpect(status().isUnauthorized());
        }
    }

    // Conjuntos de teste para o PasswordController
    @Nested
    @DisplayName("Testes do PasswordController")
    class PasswordControllerTests {

        @Test
        @DisplayName("PATCH /v1/changePassword/{id} - Deve atualizar a senha")
        void testUpdatePassword() throws Exception {
            PasswordUpdateDTO passwordDTO = new PasswordUpdateDTO();
            passwordDTO.setSenha("novaSenhaForte");

            doNothing().when(passwordService).updatePassword(1L, "novaSenhaForte");

            mockMvc.perform(patch("/v1/changePassword/{id}", 1L)
                            .header("Authorization", validToken)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(passwordDTO)))
                    .andExpect(status().isOk());
        }
    }

    // Conjuntos de teste para o UserController
    @Nested
    @DisplayName("Testes do UserController")
    class UserControllerTests {

        @Test
        @DisplayName("GET /v1/users/hello - Deve retornar mensagem simples")
        void testHelloUsers() throws Exception {
            // Precisa autenticar conforme definido pelo o SecurityConfig
            mockMvc.perform(get("/v1/users/hello")
                            .header("Authorization", validToken))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Hello Users"));
        }

        @Test
        @DisplayName("GET /v1/users - Deve listar utilizadores paginados")
        void testFindAllUsers() throws Exception {
            given(userService.findAllUsers(1, 10))
                    .willReturn(Collections.singletonList(mockUser));

            mockMvc.perform(get("/v1/users?page=1&size=10")
                            .header("Authorization", validToken))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].login").value("testeuser"));
        }

        @Test
        @DisplayName("GET /v1/users/{id} - Deve obter um utilizador por ID")
        void testFindUserById() throws Exception {
            given(userService.findUser(1L)).willReturn(Optional.of(mockUser));

            mockMvc.perform(get("/v1/users/{id}", 1L)
                            .header("Authorization", validToken))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.login").value("testeuser"));
        }

        @Test
        @DisplayName("POST /v1/users - Deve criar um novo utilizador")
        void testSaveUser() throws Exception {
            doNothing().when(userService).saveUser(any(User.class));

            mockMvc.perform(post("/v1/users")
                            .header("Authorization", validToken)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(mockUser)))
                    .andExpect(status().isCreated());
        }

        @Test
        @DisplayName("PUT /v1/users/{id} - Deve atualizar um utilizador")
        void testUpdateUser() throws Exception {
            doNothing().when(userService).updateUser(any(User.class), eq(1L));

            mockMvc.perform(put("/v1/users/{id}", 1L)
                            .header("Authorization", validToken)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(mockUser)))
                    .andExpect(status().isOk());
        }

        @Test
        @DisplayName("DELETE /v1/users/{id} - Deve apagar um utilizador")
        void testDeleteUser() throws Exception {
            // Nota: Mantém-se o nome do método 'delteUser' conforme o serviço original
            doNothing().when(userService).delteUser(1L);

            mockMvc.perform(delete("/v1/users/{id}", 1L)
                            .header("Authorization", validToken))
                    .andExpect(status().isOk());
        }
    }
}
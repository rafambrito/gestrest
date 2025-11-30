package br.com.gestrest.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representa um usuário do sistema")
public class User {

	@Schema(description = "ID único do usuário", example = "1")
    private Long usuarioId;
	
	@Schema(description = "Nome completo do usuário", example = "Rafael Brito")
    private String nome;
	
	@Schema(description = "Email do usuário", example = "rafael@example.com")
    private String email;
	
	@Schema(description = "Login do usuário", example = "rafael@example.com")
    private String login;
	
	@Schema(description = "Senha do usuário", example = "123456")
    private String senha;
	
	@Schema(description = "Estado do usuário", example = "1")
    private Integer estado;
	
	@Schema(description = "Email do usuário", example = "1")
    private Integer tipoUsuarioId;
	
	@Schema(description = "Id do endereço", example = "1")
    private Integer enderecoId;
	
	@Schema(description = "Data da ultima alteração", example = "30/11/2025 20:35")
    private LocalDateTime dataUltimaAlteracao;

    public User() {
    }

    public User(Long usuarioId,
                String nome,
                String email,
                String login,
                String senha,
                Integer estado,
                Integer tipoUsuarioId,
                Integer enderecoId,
                LocalDateTime dataUltimaAlteracao) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.estado = estado;
        this.tipoUsuarioId = tipoUsuarioId;
        this.enderecoId = enderecoId;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public LocalDateTime getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(usuarioId, user.usuarioId)
                && Objects.equals(email, user.email)
                && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, email, login);
    }

    @Override
    public String toString() {
        return "User{" +
                "usuarioId=" + usuarioId +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", estado=" + estado +
                ", tipoUsuarioId=" + tipoUsuarioId +
                ", enderecoId=" + enderecoId +
                ", dataUltimaAlteracao=" + dataUltimaAlteracao +
                '}';
    }
}

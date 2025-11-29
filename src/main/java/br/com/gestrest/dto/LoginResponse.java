package br.com.gestrest.dto;

public class LoginResponse {

    private Long usuarioId;
    private String nome;
    private String email;
    private String login;
    private Integer tipoUsuarioId;
    private String token;

    public LoginResponse(Long usuarioId, String nome, String email, String login, Integer tipoUsuarioId, String token) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.tipoUsuarioId = tipoUsuarioId;
        this.token = token;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public Integer getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public String getToken() {
        return token;
    }
}

package br.com.gestrest.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = false, length = 45)
    private String login;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(name = "data_ultima_alteracao", nullable = false)
    private LocalDateTime dataUltimaAlteracao;

    @Column(nullable = false)
    private Integer estado;   // 1 - ativo, 2 - inativo

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id", nullable = false)
    private TipoUsuario tipoUsuario;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;
}
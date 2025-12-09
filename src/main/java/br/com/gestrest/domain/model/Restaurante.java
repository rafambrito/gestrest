package br.com.gestrest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurante", schema = "gestrest")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurante_id")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "proprietario", nullable = false)
    private Usuario proprietario;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "avaliacao_id", referencedColumnName = "avaliacao_id"),
        @JoinColumn(name = "avaliacao_usuario_id", referencedColumnName = "usuario_id")
    })
    private Avaliacao avaliacao;
}

package br.com.gestrest.domain.model;

import java.time.LocalDateTime;

import br.com.gestrest.domain.pk.AvaliacaoPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "avaliacao")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Avaliacao {

    @EmbeddedId
    private AvaliacaoPK id;

    @Column(name = "comentario", length = 255)
    private String comentario;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "qtde_estrelas", nullable = false)
    private Integer qtdeEstrelas;

    // relacionamento com usuário (owner of the avaliacao)
    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
package br.com.gestrest.domain.model;

import br.com.gestrest.domain.pk.ItemCardapioPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "item_cardapio", schema = "gestrest")
public class ItemCardapio {

    @EmbeddedId
    private ItemCardapioPK id;

    @Column(nullable = false)
    private String descricao;

    private String ingredientes;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "tipo_item_cardapio_id", nullable = false)
    private TipoItemCardapio tipo;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "avaliacao_id", referencedColumnName = "avaliacao_id"),
        @JoinColumn(name = "avaliacao_usuario_id", referencedColumnName = "usuario_id")
    })
    private Avaliacao avaliacao;
}
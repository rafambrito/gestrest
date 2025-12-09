package br.com.gestrest.domain.model;

import br.com.gestrest.domain.pk.ItemCardapioPK;
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
@Table(name = "item_cardapio")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ItemCardapio {

    @EmbeddedId
    private ItemCardapioPK id = new ItemCardapioPK();

    @MapsId("restauranteId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;

    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;

    @Column(name = "ingredientes", length = 45)
    private String ingredientes;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_item_cardapio_id", nullable = false)
    private TipoItemCardapio tipoItemCardapio;
}
package br.com.gestrest.domain.model;

import br.com.gestrest.domain.pk.ItemPedidoPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_pedido")
@Getter @Setter
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "item_cardapio_id", referencedColumnName = "item_cardapio_id", insertable = false, updatable = false),
        @JoinColumn(name = "restaurante_id", referencedColumnName = "restaurante_id", insertable = false, updatable = false)
    })
    private ItemCardapio itemCardapio;

    @Column(name = "qtde_item", nullable = false)
    private Integer qtdeItem;

    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;
}
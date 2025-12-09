package br.com.gestrest.domain.model;

import br.com.gestrest.domain.pk.ItemPedidoPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "item_pedido", schema = "gestrest")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoPK id;

    @Column(name = "qtde_item", nullable = false)
    private Integer quantidade;

    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "item_cardapio_id", referencedColumnName = "item_cardapio_id"),
        @JoinColumn(name = "restaurante_id", referencedColumnName = "restaurante_id")
    })
    private ItemCardapio itemCardapio;
}

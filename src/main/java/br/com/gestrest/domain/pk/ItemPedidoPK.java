package br.com.gestrest.domain.pk;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoPK implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "pedido_id")
    private Long pedidoId;

    @Column(name = "restaurante_id")
    private Long restauranteId;

    @Column(name = "item_cardapio_id")
    private Long itemCardapioId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedidoPK)) return false;
        ItemPedidoPK that = (ItemPedidoPK) o;
        return Objects.equals(pedidoId, that.pedidoId) &&
               Objects.equals(restauranteId, that.restauranteId) &&
               Objects.equals(itemCardapioId, that.itemCardapioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, restauranteId, itemCardapioId);
    }
}
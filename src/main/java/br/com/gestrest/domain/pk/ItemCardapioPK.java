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
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ItemCardapioPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "item_cardapio_id")
    private Long itemCardapioId;

    @Column(name = "restaurante_id")
    private Long restauranteId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemCardapioPK)) return false;
        ItemCardapioPK that = (ItemCardapioPK) o;
        return Objects.equals(itemCardapioId, that.itemCardapioId) &&
               Objects.equals(restauranteId, that.restauranteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemCardapioId, restauranteId);
    }
}


package br.com.gestrest.domain.pk;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ItemCardapioPK implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "item_cardapio_id")
    private Long itemCardapioId;

    @Column(name = "restaurante_id")
    private Long restauranteId;
}
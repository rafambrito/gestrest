package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_cardapio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ItemCardapioId.class)
public class ItemCardapio {

    @Id
    @Column(name = "item_cardapio_id")
    private Long id;

    @Id
    @Column(name = "restaurante_id")
    private Long restauranteId;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", insertable = false, updatable = false)
    private Restaurante restaurante;

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
}
package br.com.gestrest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_cardapio")
@Getter @Setter
public class ItemCardapio {

    @Id
    @Column(name = "item_cardapio_id")
    private Long id;

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
    @JoinColumn(name = "tipo_item_cardapio_id")
    private TipoItemCardapio tipoItemCardapio;
}
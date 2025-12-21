package br.com.gestrest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_cardapio")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ItemCardapio {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_cardapio_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;

    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;

    @Column(name = "ingredientes", length = 255)
    private String ingredientes;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_item_cardapio_id", nullable = false)
    private TipoItemCardapio tipoItemCardapio;
}
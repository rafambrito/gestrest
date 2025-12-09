package br.com.gestrest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_item_cardapio")
public class TipoItemCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_item_id")
    private Long id;

    @Column(name = "nome_tipo", nullable = false, length = 45)
    private String nome;
}
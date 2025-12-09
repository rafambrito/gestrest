package br.com.gestrest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cardapio", schema = "gestrest")
public class Cardapio {

    @Id
    @Column(name = "restaurante_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
}
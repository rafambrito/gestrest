package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cardapio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cardapio {

    @Id
    @Column(name = "restaurante_id")
    private Long restauranteId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
}
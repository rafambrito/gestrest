package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_item_cardapio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoItemCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_item_id")
    private Integer id;

    @Column(name = "nome_tipo", nullable = false)
    private String nomeTipo;
}

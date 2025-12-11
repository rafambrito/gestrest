package br.com.gestrest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "endereco", schema="gestrest")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Endereco {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long id;

    private String rua;
    private Integer numero;

    @Column(nullable = false, length = 60)
    private String cidade;

    @Column(nullable = false, length = 12)
    private String cep;
}
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
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "cep", nullable = false)
    private String cep;
}
package br.com.gestrest.domain.pk;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AvaliacaoPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "avaliacao_id")
    private Long avaliacaoId;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvaliacaoPK)) return false;
        AvaliacaoPK that = (AvaliacaoPK) o;
        return Objects.equals(avaliacaoId, that.avaliacaoId) &&
               Objects.equals(usuarioId, that.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avaliacaoId, usuarioId);
    }
}
package br.org.serratec.trabalho_individual.DTOs;

import java.math.BigDecimal;

import br.org.serratec.trabalho_individual.entity.Prato;
import br.org.serratec.trabalho_individual.entity.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;


public record PratoDTO(
    Long id,
    @NotBlank String nome,
    @NotBlank String descricao,
    @NotNull @PositiveOrZero BigDecimal preco,
    @NotNull Tipo tipo) {

public Prato toEntity() {
    return new Prato(this.id, this.nome, this.descricao, this.preco, this.tipo);
}

}

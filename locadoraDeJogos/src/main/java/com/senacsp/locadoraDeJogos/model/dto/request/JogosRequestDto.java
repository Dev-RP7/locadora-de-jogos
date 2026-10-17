package com.senacsp.locadoraDeJogos.model.dto.request;

import com.senacsp.locadoraDeJogos.enums.Console;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record JogosRequestDto(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "A senha é obrigatória")
        String descricao,

        @NotNull(message = "O preço é obrigatório")
        @Positive(message = "O preço deve ser maior que zero")
        BigDecimal preco,

        @NotNull(message = "É necessario selecionar um console para o jogo")
        Console console,

        @NotNull(message = "A quantidade é obrigatória")
        @PositiveOrZero(message = "A quantidade não pode ser negativa")
        Integer quantidade

) {
}

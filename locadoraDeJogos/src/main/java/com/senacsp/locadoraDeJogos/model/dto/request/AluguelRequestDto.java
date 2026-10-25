package com.senacsp.locadoraDeJogos.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AluguelRequestDto(

        @NotNull(message = "O usuário é obrigatório")
        Long usuarioId,

        @NotNull(message = "O jogo é obrigatório")
        Long jogoId,

        @NotNull(message = "A quantidade de dias é obrigatória")
        @Positive(message = "A quantidade de dias deve ser maior que zero")
        Integer dias

) {
}

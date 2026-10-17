package com.senacsp.locadoraDeJogos.model.dto.response;

import com.senacsp.locadoraDeJogos.enums.Console;

public record JogosResponseDto(

        Long id,
        String nome,
        String descricao,
        double preco,
        Console console,
        int quantidade

) {
}

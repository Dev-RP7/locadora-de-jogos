package com.senacsp.locadoraDeJogos.model.dto.response;

import com.senacsp.locadoraDeJogos.enums.StatusAluguel;

import java.time.LocalDateTime;

public record AluguelResponseDto(

        Long id,
        Long usuarioId,
        String usuarioNome,
        Long jogoId,
        String jogoNome,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        StatusAluguel status

) {
}

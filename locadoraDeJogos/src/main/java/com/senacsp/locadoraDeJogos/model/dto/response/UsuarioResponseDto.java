package com.senacsp.locadoraDeJogos.model.dto.response;

import java.time.LocalDate;

public record UsuarioResponseDto(

        String nome,
        String email,
        String cpf,
        LocalDate dataNascimento
) {
}

package com.senacsp.locadoraDeJogos.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UsuarioRequestDto(

        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
                message = "A senha deve ter no mínimo 8 caracteres, com maiúscula, minúscula, número e caractere especial"
        )
        String senha,

        @NotBlank(message = "A confirmação da senha é obrigatória")
        String confirmacaoSenha,

        @CPF
        String cpf,

        @NotNull(message = "A data de nascimento é obrigatória")
        @Past(message = "A data de nascimento deve estar no passado")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento
) {
}

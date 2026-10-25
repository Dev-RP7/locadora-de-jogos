package com.senacsp.locadoraDeJogos.mapper;

import com.senacsp.locadoraDeJogos.model.dto.response.AluguelResponseDto;
import com.senacsp.locadoraDeJogos.model.entity.Aluguel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AluguelMapper {

    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "usuarioNome", source = "usuario.nome")
    @Mapping(target = "jogoId", source = "jogo.id")
    @Mapping(target = "jogoNome", source = "jogo.nome")
    AluguelResponseDto toResponse(Aluguel aluguel);

    List<AluguelResponseDto> toResponseList(List<Aluguel> alugueis);
}

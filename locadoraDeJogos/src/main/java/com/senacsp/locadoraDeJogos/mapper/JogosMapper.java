package com.senacsp.locadoraDeJogos.mapper;

import com.senacsp.locadoraDeJogos.model.dto.request.JogosRequestDto;
import com.senacsp.locadoraDeJogos.model.dto.response.JogosResponseDto;
import com.senacsp.locadoraDeJogos.model.entity.Jogos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JogosMapper {

    Jogos toEntity(JogosRequestDto dto);

    JogosResponseDto toResponse(Jogos jogos);

    List<JogosResponseDto> toResponseList(List<Jogos> jogos);

    @Mapping(target = "id", ignore = true)
    void updateEntity(JogosRequestDto dto, @MappingTarget Jogos jogos);
}

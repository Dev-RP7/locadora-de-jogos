package com.senacsp.locadoraDeJogos.mapper;

import com.senacsp.locadoraDeJogos.model.dto.request.UsuarioRequestDto;
import com.senacsp.locadoraDeJogos.model.dto.response.UsuarioResponseDto;
import com.senacsp.locadoraDeJogos.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioRequestDto dto);

    UsuarioResponseDto toResponse(Usuario usuario);

    List<UsuarioResponseDto> toResponseList(List<Usuario> usuarios);

    @Mapping(target = "id", ignore = true)
    void updateUsuario(UsuarioRequestDto dto, @MappingTarget Usuario usuario);
}

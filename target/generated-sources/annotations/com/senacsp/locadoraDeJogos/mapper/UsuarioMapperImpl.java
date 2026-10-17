package com.senacsp.locadoraDeJogos.mapper;

import com.senacsp.locadoraDeJogos.model.dto.request.UsuarioRequestDto;
import com.senacsp.locadoraDeJogos.model.dto.response.UsuarioResponseDto;
import com.senacsp.locadoraDeJogos.model.entity.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-16T21:04:46-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.4.1 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNome( dto.nome() );
        usuario.setEmail( dto.email() );
        usuario.setSenha( dto.senha() );
        usuario.setCpf( dto.cpf() );
        usuario.setDataNascimento( dto.dataNascimento() );

        return usuario;
    }

    @Override
    public UsuarioResponseDto toResponse(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        String nome = null;
        String email = null;
        String cpf = null;
        LocalDate dataNascimento = null;

        nome = usuario.getNome();
        email = usuario.getEmail();
        cpf = usuario.getCpf();
        dataNascimento = usuario.getDataNascimento();

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto( nome, email, cpf, dataNascimento );

        return usuarioResponseDto;
    }

    @Override
    public List<UsuarioResponseDto> toResponseList(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<UsuarioResponseDto> list = new ArrayList<UsuarioResponseDto>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( toResponse( usuario ) );
        }

        return list;
    }

    @Override
    public void updateUsuario(UsuarioRequestDto dto, Usuario usuario) {
        if ( dto == null ) {
            return;
        }

        usuario.setNome( dto.nome() );
        usuario.setEmail( dto.email() );
        usuario.setSenha( dto.senha() );
        usuario.setCpf( dto.cpf() );
        usuario.setDataNascimento( dto.dataNascimento() );
    }
}

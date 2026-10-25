package com.senacsp.locadoraDeJogos.mapper;

import com.senacsp.locadoraDeJogos.enums.Console;
import com.senacsp.locadoraDeJogos.model.dto.request.JogosRequestDto;
import com.senacsp.locadoraDeJogos.model.dto.response.JogosResponseDto;
import com.senacsp.locadoraDeJogos.model.entity.Jogos;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-19T12:40:01-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.4.1 (Oracle Corporation)"
)
@Component
public class JogosMapperImpl implements JogosMapper {

    @Override
    public Jogos toEntity(JogosRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Jogos jogos = new Jogos();

        jogos.setNome( dto.nome() );
        jogos.setDescricao( dto.descricao() );
        jogos.setPreco( dto.preco() );
        jogos.setConsole( dto.console() );
        jogos.setQuantidade( dto.quantidade() );

        return jogos;
    }

    @Override
    public JogosResponseDto toResponse(Jogos jogos) {
        if ( jogos == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String descricao = null;
        double preco = 0.0d;
        Console console = null;
        int quantidade = 0;

        id = jogos.getId();
        nome = jogos.getNome();
        descricao = jogos.getDescricao();
        if ( jogos.getPreco() != null ) {
            preco = jogos.getPreco().doubleValue();
        }
        console = jogos.getConsole();
        if ( jogos.getQuantidade() != null ) {
            quantidade = jogos.getQuantidade();
        }

        JogosResponseDto jogosResponseDto = new JogosResponseDto( id, nome, descricao, preco, console, quantidade );

        return jogosResponseDto;
    }

    @Override
    public List<JogosResponseDto> toResponseList(List<Jogos> jogos) {
        if ( jogos == null ) {
            return null;
        }

        List<JogosResponseDto> list = new ArrayList<JogosResponseDto>( jogos.size() );
        for ( Jogos jogos1 : jogos ) {
            list.add( toResponse( jogos1 ) );
        }

        return list;
    }

    @Override
    public void updateEntity(JogosRequestDto dto, Jogos jogos) {
        if ( dto == null ) {
            return;
        }

        jogos.setNome( dto.nome() );
        jogos.setDescricao( dto.descricao() );
        jogos.setPreco( dto.preco() );
        jogos.setConsole( dto.console() );
        jogos.setQuantidade( dto.quantidade() );
    }
}

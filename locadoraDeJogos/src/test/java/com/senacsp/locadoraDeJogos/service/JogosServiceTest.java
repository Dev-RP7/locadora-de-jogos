package com.senacsp.locadoraDeJogos.service;

import com.senacsp.locadoraDeJogos.enums.Console;
import com.senacsp.locadoraDeJogos.mapper.JogosMapper;
import com.senacsp.locadoraDeJogos.model.dto.request.JogosRequestDto;
import com.senacsp.locadoraDeJogos.model.dto.response.JogosResponseDto;
import com.senacsp.locadoraDeJogos.model.entity.Jogos;
import com.senacsp.locadoraDeJogos.repository.JogosRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JogosServiceTest {

    @Test
    void cadastrar() {
    }

    @Test
    void listar() {
    }

    @Test
    void buscar() {
    }

    @Test
    void atualizar() {
    }

    @Test
    void deletar() {
    }
}
package com.senacsp.locadoraDeJogos.service;

import com.senacsp.locadoraDeJogos.mapper.JogosMapper;
import com.senacsp.locadoraDeJogos.model.dto.request.JogosRequestDto;
import com.senacsp.locadoraDeJogos.model.dto.response.JogosResponseDto;
import com.senacsp.locadoraDeJogos.model.entity.Jogos;
import com.senacsp.locadoraDeJogos.repository.JogosRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogosService {

    private final JogosRepository jogosRepository;
    private final JogosMapper mapper;

    @Transactional
    public JogosResponseDto cadastrar(JogosRequestDto dto) {
        if (jogosRepository.existsByNome(dto.nome())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Jogo já cadastrado");
        }

        Jogos jogos = mapper.toEntity(dto);
        Jogos salvo = jogosRepository.save(jogos);
        return mapper.toResponse(salvo);
    }

    @Transactional
    public JogosResponseDto salvar(JogosRequestDto dto) {
        Jogos salvo = jogosRepository.save(mapper.toEntity(dto));
        return mapper.toResponse(salvo);
    }

    public List<JogosResponseDto> listar() {
        return mapper.toResponseList(jogosRepository.findAll());
    }

    @Transactional(readOnly = true)
    public JogosResponseDto buscar(Long id) {
        Jogos jogo = jogosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado"));
        return mapper.toResponse(jogo);
    }

    @Transactional
    public JogosResponseDto atualizar(Long id, JogosRequestDto dto) {
        Jogos jogo = jogosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado"));

        mapper.updateEntity(dto, jogo);

        return mapper.toResponse(jogosRepository.save(jogo));
    }

    @Transactional
    public void deletar(Long id) {
        if (!jogosRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado");
        }
        jogosRepository.deleteById(id);
    }
}

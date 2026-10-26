package com.senacsp.locadoraDeJogos.service;

import com.senacsp.locadoraDeJogos.enums.StatusAluguel;
import com.senacsp.locadoraDeJogos.mapper.AluguelMapper;
import com.senacsp.locadoraDeJogos.model.dto.request.AluguelRequestDto;
import com.senacsp.locadoraDeJogos.model.dto.response.AluguelResponseDto;
import com.senacsp.locadoraDeJogos.model.entity.Aluguel;
import com.senacsp.locadoraDeJogos.model.entity.Jogos;
import com.senacsp.locadoraDeJogos.model.entity.Usuario;
import com.senacsp.locadoraDeJogos.repository.AluguelRepository;
import com.senacsp.locadoraDeJogos.repository.JogosRepository;
import com.senacsp.locadoraDeJogos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AluguelService {

    private final AluguelRepository aluguelRepository;
    private final UsuarioRepository usuarioRepository;
    private final JogosRepository jogosRepository;
    private final AluguelMapper mapper;

    @Transactional
    public AluguelResponseDto alugar(AluguelRequestDto dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));

        Jogos jogo = jogosRepository.findById(dto.jogoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado"));

        if (temAcesso(usuario.getId(), jogo.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Usuário já tem um aluguel ativo deste jogo");
        }

        LocalDateTime agora = LocalDateTime.now();

        Aluguel aluguel = new Aluguel();
        aluguel.setUsuario(usuario);
        aluguel.setJogo(jogo);
        aluguel.setDataInicio(agora);
        aluguel.setDataFim(agora.plusDays(dto.dias()));
        aluguel.setStatus(StatusAluguel.ATIVO);

        return mapper.toResponse(aluguelRepository.save(aluguel));
    }

    @Transactional(readOnly = true)
    public List<AluguelResponseDto> listar() {
        return mapper.toResponseList(aluguelRepository.findAll());
    }

    // Chamado antes de liberar o jogo: se o aluguel venceu, bloqueia na hora (403)
    @Transactional(readOnly = true)
    public void verificarAcesso(Long usuarioId, Long jogoId) {
        if (!temAcesso(usuarioId, jogoId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Aluguel expirado ou inexistente para este jogo");
        }
    }

    // Usado pelo AluguelScheduler: marca como EXPIRADO os aluguéis que já venceram
    @Transactional
    public int expirarVencidos() {
        List<Aluguel> vencidos = aluguelRepository
                .findByStatusAndDataFimBefore(StatusAluguel.ATIVO, LocalDateTime.now());

        vencidos.forEach(aluguel -> aluguel.setStatus(StatusAluguel.EXPIRADO));

        return vencidos.size();
    }

    private boolean temAcesso(Long usuarioId, Long jogoId) {
        return aluguelRepository.existsByUsuarioIdAndJogoIdAndStatusAndDataFimAfter(
                usuarioId, jogoId, StatusAluguel.ATIVO, LocalDateTime.now());
    }
}

package com.senacsp.locadoraDeJogos.controller;

import com.senacsp.locadoraDeJogos.model.dto.request.AluguelRequestDto;
import com.senacsp.locadoraDeJogos.model.dto.response.AluguelResponseDto;
import com.senacsp.locadoraDeJogos.service.AluguelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;

    @PostMapping
    public ResponseEntity<AluguelResponseDto> alugar(@RequestBody @Valid AluguelRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(aluguelService.alugar(dto));
    }

    @GetMapping
    public ResponseEntity<List<AluguelResponseDto>> listar() {
        return ResponseEntity.ok(aluguelService.listar());
    }

    // 200 = pode jogar | 403 = aluguel vencido ou inexistente (jogo bloqueado)
    @GetMapping("/acesso")
    public ResponseEntity<Void> verificarAcesso(@RequestParam Long usuarioId, @RequestParam Long jogoId) {
        aluguelService.verificarAcesso(usuarioId, jogoId);
        return ResponseEntity.ok().build();
    }
}

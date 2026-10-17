package com.senacsp.locadoraDeJogos.controller;

import com.senacsp.locadoraDeJogos.model.dto.request.JogosRequestDto;
import com.senacsp.locadoraDeJogos.model.dto.response.JogosResponseDto;
import com.senacsp.locadoraDeJogos.service.JogosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jogos")
public class JogosController {

    private final JogosService jogosService;

    @PostMapping
    public ResponseEntity<JogosResponseDto> create(@RequestBody @Valid JogosRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogosService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<JogosResponseDto>> listar() {
        return ResponseEntity.ok(jogosService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogosResponseDto> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(jogosService.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogosResponseDto> atualizar(@PathVariable Long id, @RequestBody @Valid JogosRequestDto dto) {
        return ResponseEntity.ok(jogosService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        jogosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

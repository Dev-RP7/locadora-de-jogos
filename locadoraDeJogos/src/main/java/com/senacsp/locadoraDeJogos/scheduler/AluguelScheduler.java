package com.senacsp.locadoraDeJogos.scheduler;

import com.senacsp.locadoraDeJogos.service.AluguelService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AluguelScheduler {

    private final AluguelService aluguelService;

    // Roda a cada 1 minuto (precisa do @EnableScheduling na classe principal)
    @Scheduled(fixedRate = 60_000)
    public void expirarAlugueis() {
        aluguelService.expirarVencidos();
    }
}

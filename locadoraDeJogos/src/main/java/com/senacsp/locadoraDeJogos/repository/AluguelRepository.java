package com.senacsp.locadoraDeJogos.repository;

import com.senacsp.locadoraDeJogos.enums.StatusAluguel;
import com.senacsp.locadoraDeJogos.model.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    // Existe aluguel ATIVO desse usuário para esse jogo que ainda não venceu?
    boolean existsByUsuarioIdAndJogoIdAndStatusAndDataFimAfter(
            Long usuarioId, Long jogoId, StatusAluguel status, LocalDateTime agora);

    // Aluguéis ainda marcados como ATIVO, mas com a data de fim já passada
    List<Aluguel> findByStatusAndDataFimBefore(StatusAluguel status, LocalDateTime agora);
}

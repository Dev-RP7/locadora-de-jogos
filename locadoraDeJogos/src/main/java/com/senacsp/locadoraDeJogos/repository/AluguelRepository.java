package com.senacsp.locadoraDeJogos.repository;

import com.senacsp.locadoraDeJogos.enums.StatusAluguel;
<<<<<<< HEAD
import com.senacsp.locadoraDeJogos.model.entity.Aluguel;
=======
import com.senacsp.locadoraDeJogos.model.entity.Alugar;
>>>>>>> df29a53 (Quase acabando)
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

<<<<<<< HEAD
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    // Existe aluguel ATIVO desse usuário para esse jogo que ainda não venceu?
    boolean existsByUsuarioIdAndJogoIdAndStatusAndDataFimAfter(
            Long usuarioId, Long jogoId, StatusAluguel status, LocalDateTime agora);

    // Aluguéis ainda marcados como ATIVO, mas com a data de fim já passada
    List<Aluguel> findByStatusAndDataFimBefore(StatusAluguel status, LocalDateTime agora);
=======
public interface AluguelRepository extends JpaRepository<Alugar, Long> {

    boolean existsByUsuarioIdAndJogoIdAndStatusAndDataFimAfter(
            Long usuarioId, Long jogoId, StatusAluguel status, LocalDateTime agora);

    List<Alugar> findByStatusAndDataFimBefore(StatusAluguel status, LocalDateTime agora);
>>>>>>> df29a53 (Quase acabando)
}

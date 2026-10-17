package com.senacsp.locadoraDeJogos.repository;

import com.senacsp.locadoraDeJogos.model.entity.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosRepository extends JpaRepository<Jogos, Long> {
    boolean existsByNome(String nome);
}

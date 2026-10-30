package com.senacsp.locadoraDeJogos.model.entity;

import com.senacsp.locadoraDeJogos.enums.StatusAluguel;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Alugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "jogo_id")
    private Jogos jogo;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusAluguel status;
}

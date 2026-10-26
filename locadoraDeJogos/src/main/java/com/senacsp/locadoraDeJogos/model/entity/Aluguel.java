package com.senacsp.locadoraDeJogos.model.entity;

import com.senacsp.locadoraDeJogos.enums.StatusAluguel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "jogo_id", nullable = false)
    private Jogos jogo;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    // Depois dessa data o jogo fica bloqueado para o usuário
    @Column(nullable = false)
    private LocalDateTime dataFim;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAluguel status;
}

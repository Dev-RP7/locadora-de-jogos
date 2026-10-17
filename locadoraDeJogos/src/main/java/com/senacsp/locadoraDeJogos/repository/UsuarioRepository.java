package com.senacsp.locadoraDeJogos.repository;

import com.senacsp.locadoraDeJogos.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

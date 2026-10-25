package com.senacsp.locadoraDeJogos.service;

import com.senacsp.locadoraDeJogos.mapper.UsuarioMapper;
import com.senacsp.locadoraDeJogos.model.dto.request.UsuarioRequestDto;
import com.senacsp.locadoraDeJogos.model.dto.response.UsuarioResponseDto;
import com.senacsp.locadoraDeJogos.model.entity.Usuario;
import com.senacsp.locadoraDeJogos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper mapper;

    @Transactional
    public UsuarioResponseDto cadastrarUsuario(UsuarioRequestDto dto) {
        if (usuarioRepository.existsByCpf(dto.cpf())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado");
        }

        Usuario usuario = mapper.toEntity(dto);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return mapper.toResponse(usuarioSalvo);
    }

    @Transactional
    public UsuarioResponseDto salvar(UsuarioRequestDto dto) {
        Usuario salvo = usuarioRepository.save(mapper.toEntity(dto));
        return mapper.toResponse(salvo);
    }

    public List<UsuarioResponseDto> listar() {
        return mapper.toResponseList(usuarioRepository.findAll());
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDto buscar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
        return mapper.toResponse(usuario);
    }

    @Transactional
    public UsuarioResponseDto atualizar(Long id, UsuarioRequestDto dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));

        mapper.updateUsuario(dto, usuario);

        return mapper.toResponse(usuarioRepository.save(usuario));
    }

    @Transactional
    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

}

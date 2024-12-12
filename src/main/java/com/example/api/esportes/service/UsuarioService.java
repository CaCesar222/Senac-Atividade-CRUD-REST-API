package com.example.api.esportes.service;

import com.example.api.esportes.dto.UsuarioDto;
import com.example.api.esportes.exception.CustomHttpException;
import com.example.api.esportes.interfaces.IService;
import com.example.api.esportes.mappers.UsuarioMapper;
import com.example.api.esportes.model.Usuario;
import com.example.api.esportes.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UsuarioService implements IService<UsuarioDto, Integer> {

    final UsuarioRepository usuarioRepository;
    final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioDto create(UsuarioDto dto) {
        log.info("UsuarioService::create");

        Usuario usuario = usuarioMapper.toModel(dto);

        Usuario usuarioGravado = usuarioRepository.save(usuario);

        UsuarioDto usuarioDto = usuarioMapper.toDto(usuarioGravado);

        return usuarioDto;
    }

    @Override
    public UsuarioDto read(Integer id) {
        log.info("UsuarioService::read(id)");

        Usuario usuarioPesquisado = usuarioRepository.findById(id).orElseThrow(() -> new CustomHttpException.NotFoundException("id não encontrado"));

        UsuarioDto usuarioDto = usuarioMapper.toDto(usuarioPesquisado);

        return usuarioDto;
    }

    @Override
    public List<UsuarioDto> read() {
        log.info("UsuarioService::read()");

        List<Usuario> usuarioList = usuarioRepository.findAll();

        return usuarioMapper.toDtoList(usuarioList);
    }

    @Override
    public UsuarioDto update(Integer id, UsuarioDto entity) {
        log.info("UsuarioService::update(id,entity");

        Usuario usuarioPesquisado = usuarioRepository.findById(id).orElseThrow(() -> new CustomHttpException.NotFoundException("id não encontrado"));

        usuarioPesquisado.setNome(entity.getNome());
        usuarioPesquisado.setIdade(entity.getIdade());
        usuarioPesquisado.setCpf(entity.getCpf());
        usuarioPesquisado.setLogradouro(entity.getLogradouro());
        usuarioPesquisado.setCep(entity.getCep());
        usuarioPesquisado.setEstado(entity.getEstado());
        usuarioPesquisado.setComplemento(entity.getComplemento());
        usuarioPesquisado.setEmail(entity.getEmail());
        usuarioPesquisado.setTelefone(entity.getTelefone());

        Usuario usuarioAtualizado = usuarioRepository.save(usuarioPesquisado);

        UsuarioDto usuarioDto = usuarioMapper.toDto(usuarioPesquisado);

        return usuarioDto;
    }

    @Override
    public void delete(Integer id) {
        log.info("UsuarioService::delete(id)");

        usuarioRepository.deleteById(id);
    }
}

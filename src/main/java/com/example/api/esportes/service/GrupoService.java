package com.example.api.esportes.service;

import com.example.api.esportes.dto.GrupoDto;
import com.example.api.esportes.dto.UsuarioDto;
import com.example.api.esportes.exception.CustomHttpException;
import com.example.api.esportes.interfaces.IService;
import com.example.api.esportes.mappers.GrupoMapper;
import com.example.api.esportes.model.Grupo;
import com.example.api.esportes.model.Usuario;
import com.example.api.esportes.repository.GrupoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GrupoService implements IService<GrupoDto, Integer> {

    private final GrupoRepository grupoRepository;
    private final GrupoMapper grupoMapper;

    public GrupoService(GrupoRepository grupoRepository, GrupoMapper grupoMapper) {
        this.grupoRepository = grupoRepository;
        this.grupoMapper = grupoMapper;
    }

    @Override
    public GrupoDto create(GrupoDto dto) {
        log.info("GrupoService::create");

        Grupo grupo = grupoMapper.toModel(dto);
        Grupo grupoGravado = grupoRepository.save(grupo);

        return grupoMapper.toDto(grupoGravado);
    }

    @Override
    public GrupoDto read(Integer id) {
        log.info("GrupoService::read(id)");

        Grupo grupoPesquisado = grupoRepository.findById(id).orElseThrow(() -> new CustomHttpException.NotFoundException("id não encontrado"));

        GrupoDto grupoDto = grupoMapper.toDto(grupoPesquisado);

        return grupoDto;

//        Grupo grupo = grupoRepository.findById(id)
//                .orElseThrow(() -> new CustomHttpException.NotFoundException("Grupo não encontrado"));
//        return grupoMapper.toDto(grupo);
    }

    @Override
    public List<GrupoDto> read() {
        log.info("GrupoService::read()");

        List<Grupo> grupos = grupoRepository.findAll();
        return grupoMapper.toDtoList(grupos);
    }

    @Override
    public GrupoDto update(Integer id, GrupoDto dto) {
        log.info("GrupoService::update(id, dto)");

        Grupo grupo = grupoRepository.findById(id)
                .orElseThrow(() -> new CustomHttpException.NotFoundException("Grupo não encontrado"));

        grupo.setNome(dto.getNome());
        grupo.setModalidade(dto.getModalidade());
        grupo.setDateRegister(dto.getDateRegister());
        grupo.setCloseRegister(dto.getCloseRegister());

        Grupo grupoAtualizado = grupoRepository.save(grupo);

        return grupoMapper.toDto(grupoAtualizado);
    }

    @Override
    public void delete(Integer id) {
        log.info("GrupoService::delete(id)");
        grupoRepository.deleteById(id);
    }
}

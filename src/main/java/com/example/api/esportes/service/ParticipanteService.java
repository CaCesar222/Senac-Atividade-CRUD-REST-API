package com.example.api.esportes.service;

import com.example.api.esportes.dto.ParticipanteDto;
import com.example.api.esportes.exception.CustomHttpException;
import com.example.api.esportes.mappers.ParticipanteMapper;
import com.example.api.esportes.model.*;
import com.example.api.esportes.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ParticipanteService {

    final ParticipanteRepository participanteRepository;
    final UsuarioRepository usuarioRepository;
    final GrupoRepository grupoRepository;
    final EventoRepository eventoRepository;
    final ParticipanteMapper participanteMapper;

    public ParticipanteService(ParticipanteRepository participanteRepository,
                               UsuarioRepository usuarioRepository,
                               GrupoRepository grupoRepository,
                               EventoRepository eventoRepository,
                               ParticipanteMapper participanteMapper) {
        this.participanteRepository = participanteRepository;
        this.usuarioRepository = usuarioRepository;
        this.grupoRepository = grupoRepository;
        this.eventoRepository = eventoRepository;
        this.participanteMapper = participanteMapper;
    }

    public ParticipanteDto create(ParticipanteDto dto) {
        log.info("ParticipanteService::create");

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new CustomHttpException.NotFoundException("Usuário não encontrado"));

        Grupo grupo = null;
        if (dto.getGrupoId() != null) {
            grupo = grupoRepository.findById(dto.getGrupoId())
                    .orElseThrow(() -> new CustomHttpException.NotFoundException("Grupo não encontrado"));
        }

        Evento evento = null;
        if (dto.getEventoId() != null) {
            evento = eventoRepository.findById(dto.getEventoId())
                    .orElseThrow(() -> new CustomHttpException.NotFoundException("Evento não encontrado"));
        }

        Participante participante = participanteMapper.toModel(dto);
        participante.setUsuario(usuario);
        participante.setGrupo(grupo);
        participante.setEvento(evento);

        Participante participanteGravado = participanteRepository.save(participante);

        return participanteMapper.toDto(participanteGravado);
    }

    public ParticipanteDto read(Integer id) {
        log.info("ParticipanteService::read(id)");

        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new CustomHttpException.NotFoundException("Participante não encontrado"));

        return participanteMapper.toDto(participante);
    }

    public List<ParticipanteDto> read() {
        log.info("ParticipanteService::read()");

        List<Participante> participantes = participanteRepository.findAll();

        return participanteMapper.toDtoList(participantes);
    }

    public ParticipanteDto update(Integer id, ParticipanteDto dto) {
        log.info("ParticipanteService::update(id, dto)");

        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new CustomHttpException.NotFoundException("Participante não encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getGrupoId())
                .orElseThrow(() -> new CustomHttpException.NotFoundException("Usuário não encontrado"));

        Grupo grupo = null;
        if (dto.getGrupoId() != null) {
            grupo = grupoRepository.findById(dto.getGrupoId())
                    .orElseThrow(() -> new CustomHttpException.NotFoundException("Grupo não encontrado"));
        }

        Evento evento = null;
        if (dto.getEventoId() != null) {
            evento = eventoRepository.findById(dto.getGrupoId())
                    .orElseThrow(() -> new CustomHttpException.NotFoundException("Evento não encontrado"));
        }

        participante.setUsuario(usuario);
        participante.setGrupo(grupo);
        participante.setEvento(evento);

        Participante participanteAtualizado = participanteRepository.save(participante);

        return participanteMapper.toDto(participanteAtualizado);
    }

    public void delete(Integer id) {
        log.info("ParticipanteService::delete(id)");

        participanteRepository.deleteById(id);
    }
}

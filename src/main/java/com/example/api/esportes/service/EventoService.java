package com.example.api.esportes.service;

import com.example.api.esportes.dto.EventoDto;
import com.example.api.esportes.exception.CustomHttpException;
import com.example.api.esportes.interfaces.IService;
import com.example.api.esportes.mappers.EventoMapper;
import com.example.api.esportes.model.Evento;
import com.example.api.esportes.model.Grupo;
import com.example.api.esportes.repository.EventoRepository;
import com.example.api.esportes.repository.GrupoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EventoService implements IService<EventoDto, Integer> {

    final EventoRepository eventoRepository;
    final GrupoRepository grupoRepository;
    final EventoMapper eventoMapper;

    public EventoService(EventoRepository eventoRepository,
                         GrupoRepository grupoRepository,
                         EventoMapper eventoMapper) {
        this.eventoRepository = eventoRepository;
        this.grupoRepository = grupoRepository;
        this.eventoMapper = eventoMapper;
    }

    public EventoDto create(EventoDto dto) {
        log.info("EventoService::create");

        // Busca do Grupo associado
        Grupo grupoPesquisado = grupoRepository.findById(dto.getGrupoId())
                .orElseThrow(() -> new CustomHttpException.NotFoundException("Grupo não encontrado"));

        // Mapeia o DTO para o modelo e define o grupo
        Evento evento = eventoMapper.toModel(dto);
        evento.setGrupo(grupoPesquisado);

        // Salva o evento
        Evento eventoGravado = eventoRepository.save(evento);

        // Retorna o DTO do evento gravado
        return eventoMapper.toDto(eventoGravado);
    }

    public EventoDto read(Integer id) {
        log.info("EventoService::read(id)");

        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new CustomHttpException.NotFoundException("Evento não encontrado"));

        return eventoMapper.toDto(evento);
    }

    public List<EventoDto> read() {
        log.info("EventoService::read()");

        List<Evento> eventos = eventoRepository.findAll();

        return eventoMapper.toDtoList(eventos);
    }

    public EventoDto update(Integer id, EventoDto dto) {
        log.info("EventoService::update(id, dto)");

        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new CustomHttpException.NotFoundException("Evento não encontrado"));

        // Busca do Grupo associado, se necessário
        Grupo grupo = grupoRepository.findById(dto.getGrupoId())
                .orElseThrow(() -> new CustomHttpException.NotFoundException("Grupo não encontrado"));

        // Atualiza os campos do evento
        evento.setData(dto.getData());
        evento.setHora(dto.getHora());
        evento.setLogradouro(dto.getLogradouro());
        evento.setCep(dto.getCep());
        evento.setEstado(dto.getEstado());
        evento.setComplemento(dto.getComplemento());
        evento.setCloseRegister(dto.getCloseRegister());
        evento.setGrupo(grupo);

        // Salva e retorna o evento atualizado
        Evento eventoAtualizado = eventoRepository.save(evento);

        return eventoMapper.toDto(eventoAtualizado);
    }

    public void delete(Integer id) {
        log.info("EventoService::delete(id)");

        eventoRepository.deleteById(id);
    }
}

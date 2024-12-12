package com.example.api.esportes.mappers;

import com.example.api.esportes.dto.EventoDto;
import com.example.api.esportes.model.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventoMapper {
    EventoMapper INSTANCE = Mappers.getMapper(EventoMapper.class);

    @Mapping(target = "grupoId", source = "grupo.id")
    EventoDto toDto(Evento entity);

    @Mapping(target = "grupo.id", source = "grupoId")
    Evento toModel(EventoDto dto);

    List<EventoDto> toDtoList(List<Evento> entities);

    List<Evento> toModelList(List<EventoDto> dtos);

}

package com.example.api.esportes.mappers;

import com.example.api.esportes.dto.ParticipanteDto;
import com.example.api.esportes.model.Participante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParticipanteMapper {

    ParticipanteMapper INSTANCE = Mappers.getMapper(ParticipanteMapper.class);

    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "grupoId", source = "grupo.id")
    ParticipanteDto toDto(Participante entity);

    @Mapping(target = "usuario.id", source = "usuarioId")
    @Mapping(target = "grupo.id", source = "grupoId")
    Participante toModel(ParticipanteDto dto);

    List<ParticipanteDto> toDtoList(List<Participante> entities);

    List<Participante> toModelList(List<ParticipanteDto> dtos);
}

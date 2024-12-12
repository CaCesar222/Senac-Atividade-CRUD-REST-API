package com.example.api.esportes.mappers;

import com.example.api.esportes.dto.GrupoDto;
import com.example.api.esportes.model.Grupo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GrupoMapper {

    GrupoMapper INSTANCE = Mappers.getMapper(GrupoMapper.class);

    GrupoDto toDto(Grupo entity);

    Grupo toModel(GrupoDto dto);

    List<GrupoDto> toDtoList(List<Grupo> entities);

    List<Grupo> toModelList(List<GrupoDto> dtos);
}

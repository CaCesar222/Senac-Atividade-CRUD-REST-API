package com.example.api.esportes.mappers;

import com.example.api.esportes.dto.UsuarioDto;
import com.example.api.esportes.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDto toDto(Usuario entity);

    Usuario toModel(UsuarioDto dto);

    List<UsuarioDto> toDtoList(List<Usuario> entities);

    List<Usuario> toModelList(List<UsuarioDto> dtos);

}
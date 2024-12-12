package com.example.api.esportes.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GrupoDto {

    private Integer id;
    private String nome;
    private String modalidade;
    private LocalDateTime dateRegister;
    private LocalDateTime closeRegister;
}

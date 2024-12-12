package com.example.api.esportes.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class EventoDto {
    private Integer id;
    private LocalDate data;
    private String hora;
    private LocalDateTime dateRegister;
    private LocalDateTime closeRegister;
    private Integer grupoId; // Referência ao Grupo
    private String logradouro;
    private String cep;
    private String estado;
    private String complemento;
}

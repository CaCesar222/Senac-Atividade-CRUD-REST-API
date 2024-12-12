package com.example.api.esportes.dto;

import lombok.Data;

@Data
public class ParticipanteDto {
    private Integer id;
    private Integer usuarioId; // Referência ao Usuário
    private Integer grupoId;   // Referência ao Grupo
    private Integer EventoId;  // Referência ao Evento
}

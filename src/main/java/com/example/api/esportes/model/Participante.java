package com.example.api.esportes.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PARTICIPANTES")
public class Participante {

    @Id
    @SequenceGenerator(name="participante_seq_gen",
            sequenceName="participante_sequence",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="participante_seq_gen")
    @Column(name = "id_participante")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_evento")
    private Evento evento;
}

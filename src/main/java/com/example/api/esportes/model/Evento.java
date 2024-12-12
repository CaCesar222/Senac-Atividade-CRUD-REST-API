package com.example.api.esportes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter

@Entity
@Table(name = "EVENTO")
public class Evento {

    @Id
    @SequenceGenerator(name="evento_seq_gen",
            sequenceName="evento_sequence",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="evento_seq_gen")
    @Column(name = "id_evento")
    private Integer id;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "hora", nullable = false)
    private String hora;

    @Column(name = "DATE_REGISTER" , nullable = false)
    private LocalDateTime dateRegister;

    @Column(name = "CLOSE_REGISTER")
    private LocalDateTime closeRegister;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_grupo", nullable = false)
    private Grupo grupo;

    @Column(name = "LOGRADOURO", nullable = false)
    private String logradouro;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "COMPLEMENTO", nullable = false)
    private String complemento;
}

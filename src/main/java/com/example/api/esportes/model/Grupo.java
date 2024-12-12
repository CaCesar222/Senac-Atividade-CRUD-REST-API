package com.example.api.esportes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = "GRUPOS")
public class Grupo {

    @Id
    @SequenceGenerator(name="grupo_seq_gen",
            sequenceName="grupo_sequence",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="grupo_seq_gen")
    @Column(name = "id_grupo")
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "modalidade", length = 30, nullable = false)
    private String modalidade;

    @Column(name = "DATE_REGISTER" , nullable = false)
    private LocalDateTime dateRegister;

    @Column(name = "CLOSE_REGISTER")
    private LocalDateTime closeRegister;
}

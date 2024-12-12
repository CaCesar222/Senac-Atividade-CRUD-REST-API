package com.example.api.esportes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @SequenceGenerator(name="usuario_seq_gen",
            sequenceName="usuario_sequence",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuario_seq_gen")
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "NOME", length = 150, nullable = false)
    private String nome;

    @Column(name = "IDADE", nullable = false)
    private int idade;

    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "LOGRADOURO", nullable = false)
    private String logradouro;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "COMPLEMENTO", nullable = false)
    private String complemento;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;
}

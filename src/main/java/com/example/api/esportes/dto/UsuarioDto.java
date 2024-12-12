package com.example.api.esportes.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioDto {

    private Integer id;
    private String nome;
    private Integer idade;
    private String cpf;

    private String logradouro;
    private String cep;
    private String estado;
    private String complemento;

    private String email;
    private String telefone;

    private LocalDateTime dateRegister;
    private LocalDateTime closeRegister;
}

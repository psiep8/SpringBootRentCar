package com.example.springbootrentcar.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UtenteDTO {

    private Integer idUtente;

    private String nome;

    private String cognome;

    private String email;

    private String telefono;

    private String dataNascita;

    private boolean customer;

}

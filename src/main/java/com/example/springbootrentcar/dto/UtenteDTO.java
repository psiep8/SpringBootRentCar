package com.example.springbootrentcar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UtenteDTO {

    private int id;

    private String nome;

    private String cognome;

    private String password;

    private String email;

    private String telefono;

    private String dataNascita;

    private boolean customer;


}

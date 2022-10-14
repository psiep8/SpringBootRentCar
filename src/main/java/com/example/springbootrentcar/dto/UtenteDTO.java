package com.example.springbootrentcar.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class UtenteDTO {

    private int id;

    private String nome;

    private String cognome;

    private String password;

    private String email;

    private String telefono;

    private String dataNascita;

    private boolean customer;

    public UtenteDTO(int id, String nome, String cognome, String password, String email, String telefono, String dataNascita, boolean customer) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.dataNascita = dataNascita;
        this.customer = customer;
    }
}

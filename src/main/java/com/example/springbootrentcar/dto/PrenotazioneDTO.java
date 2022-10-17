package com.example.springbootrentcar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class PrenotazioneDTO {
    private int id;
    private int idUtente;
    private int idAuto;
    private String dataInizio;
    private String dataFine;
    private boolean approvata;
}

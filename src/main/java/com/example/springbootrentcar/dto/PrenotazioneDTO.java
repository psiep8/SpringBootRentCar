package com.example.springbootrentcar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class PrenotazioneDTO {
    private int id;
    private String dataInizio;
    private String dataFine;
    private boolean approvata;
}

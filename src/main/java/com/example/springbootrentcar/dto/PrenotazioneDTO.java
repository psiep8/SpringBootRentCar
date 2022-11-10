package com.example.springbootrentcar.dto;

import com.example.springbootrentcar.entity.Auto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PrenotazioneDTO {

    private Integer id;

    private String dataInizio;

    private String dataFine;

    private boolean approvata;

    private String auto;

}

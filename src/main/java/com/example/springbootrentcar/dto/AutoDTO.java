package com.example.springbootrentcar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AutoDTO {
    private Integer id;
    private String marca;
    private String modello;
    private int cilindrata;

}

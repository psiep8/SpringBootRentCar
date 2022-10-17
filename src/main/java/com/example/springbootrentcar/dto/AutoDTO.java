package com.example.springbootrentcar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AutoDTO {
    private int id;
    private String marco;
    private String modello;
    private int cilindrata;

}

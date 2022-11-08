package com.example.springbootrentcar.service;

import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Utente;

import java.util.List;


public interface UtenteService {
    void updateUtente(UtenteDTO utente);

    void deleteUtente(int id);

    List<UtenteDTO> getUtenti();

    UtenteDTO getUser(int id);

    Utente getUserByEmail(String email);

    List<UtenteDTO> getColumn(String campo, String filter);

    Utente getUtenteBySession();
}

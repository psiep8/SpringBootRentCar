package com.example.springbootrentcar.service;

import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Utente;

import java.util.List;


public interface UtenteService {
    void updateUtente(UtenteDTO utente);

    void deleteUtente(UtenteDTO utente);

    List<UtenteDTO> getUtenti();

    UtenteDTO getUser(int id);

    UtenteDTO getUserByEmail(String email);

    void approvaPrenotazione(String string, int id);

    List<UtenteDTO> getColumn(String campo, String filter);

}

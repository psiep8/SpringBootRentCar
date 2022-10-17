package com.example.springbootrentcar.service;

import com.example.springbootrentcar.entity.Utente;

import java.util.List;


public interface UtenteService {
    void updateUtente(Utente utente);

    void deleteUtente(Utente utente);

    List<Utente> getUtenti();

    Utente getUser(int id);

    Utente getUserByEmail(String email);

    void approvaPrenotazione(String string, int id);

    List<Utente> getColumn(String campo, String filter);

}

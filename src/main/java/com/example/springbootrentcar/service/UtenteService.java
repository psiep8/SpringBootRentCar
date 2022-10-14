package com.example.springbootrentcar.service;

import com.example.springbootrentcar.entity.Utente;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UtenteService {
    void updateUtente(Utente utente);

    void deleteUtente(Utente utente);

    List<Utente> getUtenti();

    Optional<Utente> getUser(int id);

    Utente getUserByEmail(String email);

    void approvaPrenotazione(String string, int id);

    List<String> getColumn(String campo, String filter);

}

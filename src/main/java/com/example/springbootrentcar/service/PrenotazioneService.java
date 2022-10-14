package com.example.springbootrentcar.service;

import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PrenotazioneService {
    void updatePrenotazione(Prenotazione prenotazione);

    void deletePrenotazione(Prenotazione prenotazione);

    List<Prenotazione> getPrenotazioni();

    Optional<Prenotazione> getPrenotazione(int id);

}

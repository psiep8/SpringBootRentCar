package com.example.springbootrentcar.service;

import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PrenotazioneService {
    void updatePrenotazione(Prenotazione prenotazione);

    void deletePrenotazione(Prenotazione prenotazione);

    List<Prenotazione> getPrenotazioni();

    Prenotazione getPrenotazione(int id);

}

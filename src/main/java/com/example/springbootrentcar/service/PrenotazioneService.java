package com.example.springbootrentcar.service;

import com.example.springbootrentcar.dto.PrenotazioneDTO;
import com.example.springbootrentcar.entity.Prenotazione;

import java.util.List;

public interface PrenotazioneService {
    void updatePrenotazione(PrenotazioneDTO prenotazioneDTO);

    void deletePrenotazione(int id);

    List<PrenotazioneDTO> getPrenotazioni();

    PrenotazioneDTO getPrenotazione(int id);

}

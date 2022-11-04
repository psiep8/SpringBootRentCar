package com.example.springbootrentcar.service;

import com.example.springbootrentcar.dto.PrenotazioneDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PrenotazioneService {
    void updatePrenotazione(PrenotazioneDTO prenotazioneDTO, int idAuto);

    void deletePrenotazione(int id);

    List<PrenotazioneDTO> getPrenotazioni();

    public void approvata(int id);

    PrenotazioneDTO getPrenotazione(int id);

}

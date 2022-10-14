package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.repository.PrenotazioneRepository;
import com.example.springbootrentcar.service.PrenotazioneService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneServiceImpl(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    @Transactional
    @Override
    public void updatePrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }

    @Transactional
    @Override
    public void deletePrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.delete(prenotazione);
    }

    @Override
    public List<Prenotazione> getPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    @Override
    public Prenotazione getPrenotazione(int id) {
        return prenotazioneRepository.getReferenceById(id);
    }

}

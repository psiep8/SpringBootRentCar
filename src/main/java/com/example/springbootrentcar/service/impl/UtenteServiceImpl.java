package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.exception.ResourceNotFoundException;
import com.example.springbootrentcar.repository.PrenotazioneRepository;
import com.example.springbootrentcar.repository.UtenteRepository;
import com.example.springbootrentcar.service.UtenteService;
import com.example.springbootrentcar.specifications.EmailSpecifications;
import com.example.springbootrentcar.specifications.FieldSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UtenteServiceImpl implements UtenteService {

    private final UtenteRepository utenteRepository;
    private final PrenotazioneRepository prenotazioneRepository;

    @Override
    @Transactional
    public void updateUtente(Utente utente) {
        utenteRepository.save(utente);
    }

    @Override
    @Transactional
    public void deleteUtente(Utente utente) {
        utenteRepository.delete(utente);
    }

    @Override
    public List<Utente> getUtenti() {
        return utenteRepository.findAll();
    }

    @Override
    public Utente getUser(int id) {
        return utenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utente non esiste con id:" + id));
    }

    @Override
    public Utente getUserByEmail(String email) {
        return utenteRepository.findOne(new EmailSpecifications(email)).orElseThrow();
    }

    @Override
    public void approvaPrenotazione(String string, int id) {
        Prenotazione prenotazione = prenotazioneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prenotazione non esiste con id:" + id));
        prenotazione.setApprovata(string.equalsIgnoreCase("Si"));
        prenotazioneRepository.save(prenotazione);
    }

    @Override
    public List<Utente> getColumn(String campo, String filter) {
        FieldSpecifications fs = new FieldSpecifications(campo, filter);
        return utenteRepository.findAll(fs);
    }

}

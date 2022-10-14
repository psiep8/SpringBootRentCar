package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.repository.PrenotazioneRepository;
import com.example.springbootrentcar.repository.UtenteRepository;
import com.example.springbootrentcar.service.UtenteService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional()
public class UtenteServiceImpl implements UtenteService {

    UtenteRepository utenteRepository;
    PrenotazioneRepository prenotazioneRepository;

    public UtenteServiceImpl(UtenteRepository utenteDAO, PrenotazioneRepository prenotazioneDAO) {
        this.utenteRepository = utenteDAO;
        this.prenotazioneRepository = prenotazioneDAO;
    }

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
        return utenteRepository.getReferenceById(id);
    }

    @Override
    public Utente getUserByEmail(String email) {
        return utenteRepository.getUserByEmail(email);
    }

    @Override
    public void approvaPrenotazione(String string, int id) {
        Prenotazione prenotazione = prenotazioneRepository.getReferenceById(id);
        prenotazione.setApprovata(string.equals("Si"));
        prenotazioneRepository.save(prenotazione);
    }

    @Override
    public List<String> getColumn(String campo, String filter) {
        return utenteRepository.getColumn(campo, filter);
    }

}

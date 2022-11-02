package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.exception.ResourceNotFoundException;
import com.example.springbootrentcar.mapper.UtenteMapper;
import com.example.springbootrentcar.repository.PrenotazioneRepository;
import com.example.springbootrentcar.repository.UtenteRepository;
import com.example.springbootrentcar.service.UtenteService;
import com.example.springbootrentcar.specifications.EmailSpecifications;
import com.example.springbootrentcar.specifications.FieldSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UtenteServiceImpl implements UtenteService {
    private final UtenteRepository utenteRepository;
    private final PrenotazioneRepository prenotazioneRepository;
    private final UtenteMapper utenteMapper;

    @Override
    @Transactional
    public void updateUtente(UtenteDTO utenteDTO) {
        if (utenteDTO.getId() != 0) {
            Utente utente = utenteRepository.findById(utenteDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Utente non esiste con id:" + utenteDTO.getId()));
            utenteMapper.settersDTOtoEntity(utenteDTO, utente);
            utenteRepository.save(utente);
        } else {
            utenteRepository.save(utenteMapper.fromDTOtoEntity(utenteDTO));
        }
    }

    @Override
    @Transactional
    public void deleteUtente(int id) {
        Utente utente = utenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utente non esiste con id:" + id));
        utenteRepository.deleteById(utente.getIdUtente());
    }

    @Override
    public List<UtenteDTO> getUtenti() {
        List<Utente> utenti = utenteRepository.findAll();
        return utenteMapper.getAllUtentiDTO(utenti);
    }

    @Override
    public UtenteDTO getUser(int id) {
        return utenteMapper.fromEntityToDTO(utenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utente non esiste con id:" + id)));
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
    public List<UtenteDTO> getColumn(String campo, String filter) {
        FieldSpecifications fs = new FieldSpecifications(campo, filter);
        return utenteMapper.getAllUtentiDTO(utenteRepository.findAll(fs));
    }


}

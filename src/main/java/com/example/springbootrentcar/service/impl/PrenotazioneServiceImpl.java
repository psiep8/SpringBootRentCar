package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.dto.PrenotazioneDTO;
import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.exception.ResourceNotFoundException;
import com.example.springbootrentcar.mapper.PrenotazioneMapper;
import com.example.springbootrentcar.repository.PrenotazioneRepository;
import com.example.springbootrentcar.service.PrenotazioneService;
import com.example.springbootrentcar.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PrenotazioneServiceImpl implements PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;
    private final PrenotazioneMapper prenotazioneMapper;
    private final UtenteService utenteService;

    @Transactional
    @Override
    public void updatePrenotazione(PrenotazioneDTO prenotazioneDTO, int idAuto) {
        if (prenotazioneDTO.getId().intValue() != 0) {
            prenotazioneDTO.setApprovata(false);
            Prenotazione prenotazione = prenotazioneRepository.findById(prenotazioneDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Utente non esiste con id:" + prenotazioneDTO.getId()));
            prenotazione.setDataInizio(LocalDate.parse(prenotazioneDTO.getDataInizio()));
            prenotazione.setDataFine(LocalDate.parse(prenotazioneDTO.getDataFine()));
            Auto auto = new Auto();
            auto.setIdAuto(idAuto);
            prenotazione.setAuto(auto);
            prenotazioneRepository.save(prenotazione);
        } else {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getName();
            Utente u = utenteService.getUserByEmail(email);
            Prenotazione p = prenotazioneMapper.fromDTOtoEntity(prenotazioneDTO);
            p.setUtente(u);
            Auto auto = new Auto();
            auto.setIdAuto(idAuto);
            p.setAuto(auto);
            prenotazioneRepository.save(p);
        }
    }

    @Transactional
    @Override
    public void deletePrenotazione(int id) {
        Prenotazione prenotazione = prenotazioneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utente non esiste con id:" + id));
        prenotazioneRepository.deleteById(prenotazione.getId());
    }

    @Override
    public List<PrenotazioneDTO> getPrenotazioni() {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findAll();
        return prenotazioneMapper.getAllPrenotazioniDTO(prenotazioni);
    }

    @Override
    public List<PrenotazioneDTO> listPrenotazioniToApprove() {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findAll();
        List<Prenotazione> result = new ArrayList<>();
        for (Prenotazione p : prenotazioni) {
            if (!p.isApprovata()) {
                result.add(p);
            }
        }
        return prenotazioneMapper.getAllPrenotazioniDTO(result);
    }

    @Override
    public void approvata(int id) {
        Prenotazione prenotazioneDaApprovare = prenotazioneRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Prenotazione non esiste con id:" + id)));
        prenotazioneDaApprovare.setApprovata(true);
        prenotazioneRepository.save(prenotazioneDaApprovare);

    }

    @Override
    public PrenotazioneDTO getPrenotazione(int id) {
        return prenotazioneMapper.fromEntityToDTO(prenotazioneRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Prenotazione non esiste con id:" + id))));
    }



}

package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.dto.PrenotazioneDTO;
import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.exception.ResourceNotFoundException;
import com.example.springbootrentcar.mapper.PrenotazioneMapper;
import com.example.springbootrentcar.repository.PrenotazioneRepository;
import com.example.springbootrentcar.service.PrenotazioneService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PrenotazioneServiceImpl implements PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;
    private final PrenotazioneMapper prenotazioneMapper;

    @Transactional
    @Override
    public void updatePrenotazione(PrenotazioneDTO prenotazioneDTO) {
        if (prenotazioneDTO.getId() != 0) {
            Prenotazione prenotazione = prenotazioneRepository.findById(prenotazioneDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Utente non esiste con id:" + prenotazioneDTO.getId()));
            prenotazione.setDataInizio(LocalDate.parse(prenotazioneDTO.getDataInizio()));
            prenotazione.setDataFine(LocalDate.parse(prenotazioneDTO.getDataFine()));
            prenotazioneRepository.save(prenotazione);
        } else {
            prenotazioneRepository.save(prenotazioneMapper.fromDTOtoEntity(prenotazioneDTO));
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
    public PrenotazioneDTO getPrenotazione(int id) {
        return prenotazioneMapper.fromEntityToDTO(prenotazioneRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Prenotazione non esiste con id:" + id))));
    }


}

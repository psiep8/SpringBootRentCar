package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.dto.PrenotazioneDTO;
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
        prenotazioneRepository.save(prenotazioneMapper.fromDTOtoEntity(prenotazioneDTO));
    }

    @Transactional
    @Override
    public void deletePrenotazione(PrenotazioneDTO prenotazioneDTO) {
        prenotazioneRepository.delete(prenotazioneMapper.fromDTOtoEntity(prenotazioneDTO));
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

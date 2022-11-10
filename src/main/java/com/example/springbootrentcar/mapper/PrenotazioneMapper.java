package com.example.springbootrentcar.mapper;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.dto.PrenotazioneDTO;
import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.exception.ResourceNotFoundException;
import com.example.springbootrentcar.repository.AutoRepository;
import com.example.springbootrentcar.repository.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PrenotazioneMapper {

    public List<PrenotazioneDTO> getAllPrenotazioniDTO(List<Prenotazione> prenotazioni) {
        return prenotazioni.stream().map(this::fromEntityToDTO).collect(Collectors.toList());
    }

    public Prenotazione fromDTOtoEntity(PrenotazioneDTO prenotazioneDTO) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataInizio(LocalDate.parse(prenotazioneDTO.getDataInizio()));
        prenotazione.setDataFine(LocalDate.parse(prenotazioneDTO.getDataFine()));
        prenotazione.setApprovata(prenotazioneDTO.isApprovata());
        return prenotazione;
    }

    public PrenotazioneDTO fromEntityToDTO(Prenotazione prenotazione) {
        PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
        prenotazioneDTO.setId(prenotazione.getId());
        prenotazioneDTO.setDataInizio(prenotazione.getDataInizio().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        prenotazioneDTO.setDataFine(prenotazione.getDataFine().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        prenotazioneDTO.setApprovata(prenotazione.isApprovata());
        prenotazioneDTO.setAuto(prenotazione.getAuto().getMarca() + " " + prenotazione.getAuto().getModello());
        return prenotazioneDTO;
    }

}

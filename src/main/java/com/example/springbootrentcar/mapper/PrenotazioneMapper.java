package com.example.springbootrentcar.mapper;

import com.example.springbootrentcar.entity.Prenotazione;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PrenotazioneMapper {
    private final ModelMapper mapper;

    public Prenotazione fromDTOtoEntity(com.example.springbootrentcar.dto.PrenotazioneDTO prenotazioneDTO) {
        return mapper.map(prenotazioneDTO, Prenotazione.class);
    }

    public com.example.springbootrentcar.dto.PrenotazioneDTO fromEntityToDTO(Prenotazione prenotazione) {
        return mapper.map(prenotazione, com.example.springbootrentcar.dto.PrenotazioneDTO.class);
    }

}

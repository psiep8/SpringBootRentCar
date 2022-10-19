package com.example.springbootrentcar.mapper;


import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.repository.UtenteRepository;
import com.example.springbootrentcar.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UtenteMapper {
    private final ModelMapper mapper;

    public List<UtenteDTO> getAllUtentiDTO(List<Utente> utenti) {
     return utenti.stream().map(utente -> mapper.map(utente, UtenteDTO.class)).collect(Collectors.toList());
    }

    public Utente fromDTOtoEntity(UtenteDTO utenteDTO) {
        return mapper.map(utenteDTO, Utente.class);
    }

    public UtenteDTO fromEntityToDTO(Utente utente) {
        return mapper.map(utente, UtenteDTO.class);
    }
}

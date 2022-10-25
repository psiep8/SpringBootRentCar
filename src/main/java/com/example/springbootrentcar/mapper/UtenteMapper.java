package com.example.springbootrentcar.mapper;


import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.repository.UtenteRepository;
import com.example.springbootrentcar.service.UtenteService;
import com.example.springbootrentcar.service.impl.UtenteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UtenteMapper {

    public List<UtenteDTO> getAllUtentiDTO(List<Utente> utenti) {
        return utenti.stream().map(this::fromEntityToDTO).collect(Collectors.toList());
    }

    public Utente fromDTOtoEntity(UtenteDTO utenteDTO) {
        Utente utente = new Utente();
        SettersDTOtoEntity(utenteDTO, utente);
        return utente;
    }

    public static void SettersDTOtoEntity(UtenteDTO utenteDTO, Utente utente) {
        utente.setNome(utenteDTO.getNome());
        utente.setCognome(utenteDTO.getCognome());
        utente.setPassword(utenteDTO.getPassword());
        utente.setEmail(utenteDTO.getEmail());
        utente.setTelefono(utenteDTO.getTelefono());
        utente.setDataNascita(LocalDate.parse(utenteDTO.getDataNascita()));
        utente.setCustomer(utenteDTO.isCustomer());
    }

    public UtenteDTO fromEntityToDTO(Utente utente) {
        UtenteDTO utenteDTO = new UtenteDTO();
        utenteDTO.setId(utente.getIdUtente());
        utenteDTO.setNome(utente.getNome());
        utenteDTO.setCognome(utente.getCognome());
        utenteDTO.setPassword(utente.getPassword());
        utenteDTO.setEmail(utente.getEmail());
        utenteDTO.setTelefono(utente.getTelefono());
        utenteDTO.setDataNascita(utente.getDataNascita().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        utenteDTO.setCustomer(utente.isCustomer());
        return utenteDTO;
    }

}

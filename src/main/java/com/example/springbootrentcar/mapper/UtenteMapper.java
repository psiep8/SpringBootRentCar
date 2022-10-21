package com.example.springbootrentcar.mapper;


import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Utente;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UtenteMapper {
    private final ModelMapper mapper;

    public UtenteMapper(ModelMapper mapper) {
        this.mapper = mapper;
        this.mapper.addConverter(toLocalDate);
    }


    public List<UtenteDTO> getAllUtentiDTO(List<Utente> utenti) {
        return utenti.stream().map(utente -> mapper.map(utente, UtenteDTO.class)).collect(Collectors.toList());
    }

    public Utente fromDTOtoEntity(UtenteDTO utenteDTO) {
        return mapper.map(utenteDTO, Utente.class);
    }

    public UtenteDTO fromEntityToDTO(Utente utente) {
        return mapper.map(utente, UtenteDTO.class);
    }

    Converter<String, LocalDate> toLocalDate = new AbstractConverter<String, LocalDate>() {
        protected LocalDate convert(String source) {
            if (source == null || source.isEmpty()) {
                return LocalDate.now();
            }
            return LocalDate.parse(source);
        }
    };
}

package com.example.springbootrentcar.mapper;

import com.example.springbootrentcar.entity.Prenotazione;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

public class PrenotazioneMapper {
    private final ModelMapper mapper;

    public PrenotazioneMapper(ModelMapper mapper) {
        this.mapper = mapper;
        this.mapper.addConverter(toLocalDate);
    }

    public Prenotazione fromDTOtoEntity(com.example.springbootrentcar.dto.PrenotazioneDTO prenotazioneDTO) {
        return mapper.map(prenotazioneDTO, Prenotazione.class);
    }

    public com.example.springbootrentcar.dto.PrenotazioneDTO fromEntityToDTO(Prenotazione prenotazione) {
        return mapper.map(prenotazione, com.example.springbootrentcar.dto.PrenotazioneDTO.class);
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

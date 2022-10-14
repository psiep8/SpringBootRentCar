package com.example.springbootrentcar.mapper;

import com.example.springbootrentcar.repository.UtenteRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PrenotazioneMapper {
/*
    private static UtenteRepository u = new UtenteDAOImpl();
    private static AutoDAO a = new AutoDAOImpl();

    public PrenotazioneMapper(UtenteDAO u, AutoDAO a) {
        this.u = u;
        this.a = a;
    }

    public static Prenotazione fromDTOtoEntity(PrenotazioneDTO prenotazioneDTO) {
        Utente utente = u.getUser(prenotazioneDTO.getIdUtente());
        Auto auto = a.getAuto(prenotazioneDTO.getIdAuto());
        return new Prenotazione(
                prenotazioneDTO.getId(),
                LocalDate.parse(prenotazioneDTO.getDataInizio()),
                LocalDate.parse(prenotazioneDTO.getDataFine()),
                prenotazioneDTO.isApprovata(),
                utente,
                auto);
    }
*/
}

package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.dto.PrenotazioneDTO;
import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.exception.ResourceNotFoundException;
import com.example.springbootrentcar.mapper.PrenotazioneMapper;
import com.example.springbootrentcar.service.PrenotazioneService;
import com.example.springbootrentcar.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/prenotazione")
@RequiredArgsConstructor
public class PrenotazioneController {
    private final PrenotazioneService prenotazioneService;
    private final PrenotazioneMapper prenotazioneMapper;
    private final UtenteService utenteService;

    @GetMapping("")
    public List<PrenotazioneDTO> listPrenotazioni() {
        Utente u = utenteService.getUtenteBySession();
        return prenotazioneMapper.getAllPrenotazioniDTO(u.getPrenotazioniFromUtenteItems());
    }

    @RequestMapping(value = "/upSert", method = {RequestMethod.POST, RequestMethod.PUT})
    public void upSertPrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO, @RequestParam("autoID") int idAuto) {
        prenotazioneService.updatePrenotazione(prenotazioneDTO, idAuto);
    }

    @GetMapping("/{id}")
    public PrenotazioneDTO getPrenotazioneById(@PathVariable int id) {
        return prenotazioneService.getPrenotazione(id);
    }

    @PostMapping("/approvata")
    public void approvata(@RequestParam("prenotazioneID") int id) {
        prenotazioneService.approvata(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePrenotazione(@PathVariable int id) throws Exception {
        prenotazioneService.deletePrenotazione(id);

    }

}

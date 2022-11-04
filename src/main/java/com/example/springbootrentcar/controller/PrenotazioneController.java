package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.dto.PrenotazioneDTO;
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
        Utente u = getUtenteBySession();
        return prenotazioneMapper.getAllPrenotazioniDTO(u.getPrenotazioniFromUtenteItems());
    }

    @PostMapping("/save")
    public void savePrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO, @RequestParam("autoID") int idAuto) {
        prenotazioneService.updatePrenotazione(prenotazioneDTO, idAuto);
    }

    @GetMapping("/{id}")
    public PrenotazioneDTO getPrenotazioneById(@PathVariable int id) {
        return prenotazioneService.getPrenotazione(id);
    }

    @PutMapping("/edit")
    public ResponseEntity<PrenotazioneDTO> updatePrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO, @RequestParam("autoID") int idAuto) {
        prenotazioneService.updatePrenotazione(prenotazioneDTO, idAuto);
        return ResponseEntity.ok(prenotazioneDTO);
    }


    @PostMapping("/approvata")
    public void approvata(@RequestParam("prenotazioneID") int id) {
        prenotazioneService.approvata(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePrenotazione(@PathVariable int id) throws Exception {
        LocalDate dataInizio = LocalDate.parse(prenotazioneService.getPrenotazione(id).getDataInizio());
        if (dataInizio.until(LocalDate.now(), ChronoUnit.DAYS) > 2) {
            prenotazioneService.deletePrenotazione(id);
        } else {
            throw new Exception("Errore, non è possibile cancellare entro due giorni dalla prenotazione");
        }
    }

    private Utente getUtenteBySession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return utenteService.getUserByEmail(email);
    }

}

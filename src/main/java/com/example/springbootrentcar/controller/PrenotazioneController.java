package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.dto.PrenotazioneDTO;
import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.mapper.PrenotazioneMapper;
import com.example.springbootrentcar.service.PrenotazioneService;
import com.example.springbootrentcar.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazione")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
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
    public void savePrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO) {
        prenotazioneDTO.setApprovata(false);
        prenotazioneService.updatePrenotazione(prenotazioneDTO);
    }

    @GetMapping("/{id}")
    public PrenotazioneDTO getPrenotazioneById(@PathVariable int id) {
        return prenotazioneService.getPrenotazione(id);
    }

    @PutMapping("/edit")
    public ResponseEntity<PrenotazioneDTO> updatePrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO) {
        prenotazioneService.updatePrenotazione(prenotazioneDTO);
        return ResponseEntity.ok(prenotazioneDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePrenotazione(@PathVariable int id) {
        prenotazioneService.deletePrenotazione(id);
    }

    private Utente getUtenteBySession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return utenteService.getUserByEmail(email);
    }

}

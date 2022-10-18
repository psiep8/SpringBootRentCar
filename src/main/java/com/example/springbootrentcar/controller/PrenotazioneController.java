package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.service.PrenotazioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazione")
@RequiredArgsConstructor
public class PrenotazioneController {
    private final PrenotazioneService prenotazioneService;

    @GetMapping("")
    public List<Prenotazione> listPrenotazioni() {
        return prenotazioneService.getPrenotazioni();
    }

    @PostMapping("/save")
    public void savePrenotazione(@RequestBody Prenotazione prenotazione) {
        prenotazioneService.updatePrenotazione(prenotazione);
    }

    @GetMapping("/{id}")
    public Prenotazione getPrenotazioneById(@PathVariable int id) {
        return prenotazioneService.getPrenotazione(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Prenotazione> updatePrenotazione(@PathVariable int id, @RequestBody Prenotazione prenotazione) {
        Prenotazione p = prenotazioneService.getPrenotazione(id);
        p.setDataInizio(prenotazione.getDataInizio());
        p.setDataFine(prenotazione.getDataFine());
        prenotazioneService.updatePrenotazione(p);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Prenotazione> deletePrenotazione(@PathVariable int id) {
        Prenotazione p = prenotazioneService.getPrenotazione(id);
        prenotazioneService.deletePrenotazione(p);
        return ResponseEntity.ok(p);
    }

}

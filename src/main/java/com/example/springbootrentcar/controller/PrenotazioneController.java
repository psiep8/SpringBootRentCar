package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.dto.PrenotazioneDTO;
import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.service.PrenotazioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazione")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PrenotazioneController {
    private final PrenotazioneService prenotazioneService;

    @GetMapping("")
    public List<PrenotazioneDTO> listPrenotazioni() {
        return prenotazioneService.getPrenotazioni();
    }

    @PostMapping("/save")
    public void savePrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO) {
        prenotazioneService.updatePrenotazione(prenotazioneDTO);
    }

    @GetMapping("/{id}")
    public PrenotazioneDTO getPrenotazioneById(@PathVariable int id) {
        return prenotazioneService.getPrenotazione(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<PrenotazioneDTO> updatePrenotazione(@PathVariable int id, @RequestBody PrenotazioneDTO prenotazioneDTO) {
        PrenotazioneDTO p = prenotazioneService.getPrenotazione(id);
        p.setDataInizio(prenotazioneDTO.getDataInizio());
        p.setDataFine(prenotazioneDTO.getDataFine());
        prenotazioneService.updatePrenotazione(p);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PrenotazioneDTO> deletePrenotazione(@PathVariable int id) {
        PrenotazioneDTO p = prenotazioneService.getPrenotazione(id);
        prenotazioneService.deletePrenotazione(p);
        return ResponseEntity.ok(p);
    }

}

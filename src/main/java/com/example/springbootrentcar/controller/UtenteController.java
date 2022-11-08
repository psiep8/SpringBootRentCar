package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.dto.PrenotazioneDTO;
import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.mapper.UtenteMapper;
import com.example.springbootrentcar.service.PrenotazioneService;
import com.example.springbootrentcar.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/utente")
@RequiredArgsConstructor
public class UtenteController {
    private final UtenteService utenteService;

    private final PrenotazioneService prenotazioneService;

    @GetMapping("")
    public List<UtenteDTO> listUtenti() {
        return utenteService.getUtenti();
    }

    @GetMapping("/listPrenotazioni")
    public List<PrenotazioneDTO> listPrenotazioni() {
        List<PrenotazioneDTO> list = prenotazioneService.getPrenotazioni();
        List<PrenotazioneDTO> result = new ArrayList<>();
        for (PrenotazioneDTO p : list) {
            if (!p.isApprovata()) {
                result.add(p);
            }
        }
        return result;
    }

    @PostMapping("/approvata")
    public void approvata(@RequestParam("prenotazioneID") int id) {
        prenotazioneService.approvata(id);
    }

    @PostMapping("/save")
    public void saveUtente(@RequestBody UtenteDTO utenteDTO) {
        utenteDTO.setCustomer(true);
        utenteService.updateUtente(utenteDTO);
    }

    @GetMapping("/id/{id}")
    public UtenteDTO getUtenteById(@PathVariable int id) {
        return utenteService.getUser(id);
    }

    @GetMapping("/email")
    public Utente getUserByEmail(@RequestParam String email) {
        return utenteService.getUserByEmail(email);
    }

    @PutMapping("/edit")
    public ResponseEntity<UtenteDTO> updateUtente(@RequestBody UtenteDTO utenteDTO) {
        utenteService.updateUtente(utenteDTO);
        return ResponseEntity.ok(utenteDTO);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteUtente(@PathVariable int id) {
        utenteService.deleteUtente(id);
    }

    @GetMapping("/filter/{campo}/{filter}")
    public ResponseEntity<List<UtenteDTO>> getColumn(@PathVariable("campo") String campo, @PathVariable("filter") String filter) {
        List<UtenteDTO> filteredField = utenteService.getColumn(campo, filter);
        return ResponseEntity.ok(filteredField);
    }


}

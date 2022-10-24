package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utente")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UtenteController {
    private final UtenteService utenteService;

    @GetMapping("")
    public List<UtenteDTO> listUtenti() {
        return utenteService.getUtenti();
    }

    @PostMapping("/save")
    public void saveUtente(@RequestBody UtenteDTO utenteDTO) {
        utenteDTO.setCustomer(true);
        utenteService.updateUtente(utenteDTO);
    }

    @GetMapping("/{id}")
    public UtenteDTO getUtenteById(@PathVariable int id) {
        return utenteService.getUser(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UtenteDTO> updateUtente(@PathVariable int id, @RequestBody UtenteDTO utenteDTO) {
        utenteService.updateUtente(utenteDTO);
        return ResponseEntity.ok(utenteDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UtenteDTO> deleteUtente(@PathVariable int id) {
        UtenteDTO u = utenteService.getUser(id);
        utenteService.deleteUtente(u);
        return ResponseEntity.ok(u);
    }

    @PostMapping("/approvata")
    public void approvata(@RequestParam("approved") String approvata, @RequestParam int id) {
        utenteService.approvaPrenotazione(approvata, id);
    }

    @GetMapping("/filter/{campo}/{filter}")
    public ResponseEntity<List<UtenteDTO>> getColumn(@PathVariable("campo") String campo, @PathVariable("filter") String filter) {
        List<UtenteDTO> filteredField = utenteService.getColumn(campo, filter);
        return ResponseEntity.ok(filteredField);
    }


}

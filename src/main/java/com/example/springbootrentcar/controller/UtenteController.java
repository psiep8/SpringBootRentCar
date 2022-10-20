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
public class UtenteController {
    private final UtenteService utenteService;

    @GetMapping("")
    public List<UtenteDTO> listUtenti() {
        return utenteService.getUtenti();
    }

    @PostMapping("/save")
    public void saveUtente(@RequestBody UtenteDTO utenteDTO) {
        utenteService.updateUtente(utenteDTO);
    }

    @GetMapping("/{id}")
    public UtenteDTO getUtenteById(@PathVariable int id) {
        return utenteService.getUser(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UtenteDTO> updateUtente(@PathVariable int id, @RequestBody UtenteDTO utenteDTO) {
        UtenteDTO u = utenteService.getUser(id);
        u.setNome(utenteDTO.getNome());
        u.setCognome(utenteDTO.getCognome());
        u.setPassword(utenteDTO.getPassword());
        u.setEmail(utenteDTO.getEmail());
        u.setTelefono(utenteDTO.getTelefono());
        u.setDataNascita(utenteDTO.getDataNascita());
        utenteService.updateUtente(u);
        return ResponseEntity.ok(u);
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

    /*@GetMapping("/{email}")
    public UtenteDTO getUserByEmail(@PathVariable("email") String email) {
        return utenteService.getUserByEmail(email);
    }*/

    @GetMapping("/filter/{campo}/{filter}")
    public ResponseEntity<List<UtenteDTO>> getColumn(@PathVariable("campo") String campo, @PathVariable("filter") String filter) {
        List<UtenteDTO> filteredField = utenteService.getColumn(campo, filter);
        return ResponseEntity.ok(filteredField);
    }


}

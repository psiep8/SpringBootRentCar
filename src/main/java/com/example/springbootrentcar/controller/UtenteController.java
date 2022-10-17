package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.service.UtenteService;
import com.example.springbootrentcar.specifications.FieldSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class UtenteController {
    private final UtenteService utenteService;

    @GetMapping("")
    public List<Utente> listUtenti() {
        return utenteService.getUtenti();
    }

    @PostMapping("/save")
    public void saveUtente(@RequestBody Utente utente) {
        utenteService.updateUtente(utente);
    }

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable int id) {
        return utenteService.getUser(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Utente> updateUtente(@PathVariable int id, @RequestBody Utente utente) {
        Utente u = utenteService.getUser(id);
        u.setNome(utente.getNome());
        u.setCognome(utente.getCognome());
        u.setPassword(utente.getPassword());
        u.setEmail(utente.getEmail());
        u.setTelefono(utente.getTelefono());
        u.setDataNascita(utente.getDataNascita());
        utenteService.updateUtente(u);
        return ResponseEntity.ok(u);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Utente> deleteUtente(@PathVariable int id) {
        Utente u = utenteService.getUser(id);
        utenteService.deleteUtente(u);
        return ResponseEntity.ok(u);
    }

    @PostMapping("/approvata")
    public void approvata(@RequestParam("approved") String approvata, @RequestParam int id) {
        utenteService.approvaPrenotazione(approvata, id);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Utente> getUserByUsername(@PathVariable("email") String email) {
        Utente user = utenteService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/filter/{filter}/{campo}")
    public ResponseEntity<List<Utente>> getColumn(@PathVariable("campo") String campo, @PathVariable("filter") String filter) {
        List<Utente> filteredField = utenteService.getColumn(campo, filter);
        return ResponseEntity.ok(filteredField);

    }


}

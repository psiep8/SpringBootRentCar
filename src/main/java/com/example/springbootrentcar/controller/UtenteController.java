package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class UtenteController {
    //private static final Logger logger = LoggerFactory.getLogger(UtenteController.class);

    private final UtenteService utenteService;

    @GetMapping("/")
    public List<Utente> listUtenti() {
        return utenteService.getUtenti();
    }

    @PostMapping("/")
    public void saveUtente(@RequestBody Utente utente) {
        utenteService.updateUtente(utente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Utente>> getUtenteById(@PathVariable int id) {
        Optional<Utente> utente = utenteService.getUser(id);
        if (utente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(utente, HttpStatus.OK);
        }
    }

    // continuare
}

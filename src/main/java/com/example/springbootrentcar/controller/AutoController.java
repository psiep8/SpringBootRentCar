package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auto")
@RequiredArgsConstructor
public class AutoController {
    private final AutoService autoService;

    @GetMapping("")
    public List<Auto> listAuto() {
        return autoService.getAutoList();
    }

    @PostMapping("/save")
    public void saveAuto(@RequestBody Auto auto) {
        autoService.updateAuto(auto);
    }

    @GetMapping("/{id}")
    public Auto getAutoById(@PathVariable int id) {
        return autoService.getAuto(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Auto> updateAuto(@PathVariable int id, @RequestBody Auto auto) {
        Auto a = autoService.getAuto(id);
        a.setMarca(auto.getMarca());
        a.setModello(auto.getModello());
        a.setCilindrata(auto.getCilindrata());
        autoService.updateAuto(a);
        return ResponseEntity.ok(a);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Auto> deleteAuto(@PathVariable int id) {
        Auto a = autoService.getAuto(id);
        autoService.deleteAuto(a);
        return ResponseEntity.ok(a);
    }

    @PostMapping("/filterDate/")
    public ResponseEntity<List<Auto>> getFreeVehicle(@RequestParam("inizio") String inizio, @RequestParam("fine") String fine) {
        //List<Auto> autoDisponibili = autoService.getDataRange(inizio, fine);
        //return ResponseEntity.ok(autoDisponibili);
        return null;
    }

}

package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/auto")
@RequiredArgsConstructor
public class AutoController {
    private final AutoService autoService;

    @GetMapping("")
    public List<AutoDTO> listAuto() {
        return autoService.getAutoList();
    }

    @PostMapping("/save")
    public void saveAuto(@RequestBody AutoDTO autoDTO) {
        autoService.updateAuto(autoDTO);
    }

    @GetMapping("/{id}")
    public AutoDTO getAutoById(@PathVariable int id) {
        return autoService.getAuto(id);
    }

    @PutMapping("/edit")
    public ResponseEntity<AutoDTO> updateAuto(@RequestBody AutoDTO autoDTO) {
        autoService.updateAuto(autoDTO);
        return ResponseEntity.ok(autoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuto(@PathVariable int id) {
        autoService.deleteAuto(id);
    }

    @PostMapping("/filterDate")
    public ResponseEntity<List<AutoDTO>> getDataRange(@RequestParam("inizio") String inizio, @RequestParam("fine") String fine) {
        List<AutoDTO> autoDisponibili = autoService.getDataRange(LocalDate.parse(inizio), LocalDate.parse(fine));
        return ResponseEntity.ok(autoDisponibili);
    }

}

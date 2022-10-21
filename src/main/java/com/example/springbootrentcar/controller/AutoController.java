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
@CrossOrigin(origins = "http://localhost:4200")
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

    @PutMapping("/edit/{id}")
    public ResponseEntity<AutoDTO> updateAuto(@PathVariable int id, @RequestBody AutoDTO autoDTO) {
        AutoDTO a = autoService.getAuto(id);
        a.setMarca(autoDTO.getMarca());
        a.setModello(autoDTO.getModello());
        a.setCilindrata(autoDTO.getCilindrata());
        autoService.updateAuto(a);
        return ResponseEntity.ok(a);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AutoDTO> deleteAuto(@PathVariable int id) {
        AutoDTO a = autoService.getAuto(id);
        autoService.deleteAuto(a);
        return ResponseEntity.ok(a);
    }

    @PostMapping("/filterDate")
    public ResponseEntity<List<AutoDTO>> getDataRange(@RequestParam("inizio") String inizio, @RequestParam("fine") String fine) {
        List<AutoDTO> autoDisponibili = autoService.getDataRange(LocalDate.parse(inizio), LocalDate.parse(fine));
        return ResponseEntity.ok(autoDisponibili);
    }

}

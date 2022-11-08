package com.example.springbootrentcar.controller;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.dto.PrenotazioneDTO;
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

    @RequestMapping(value = "/upSert", method = {RequestMethod.POST, RequestMethod.PUT})
    public void upSertAuto(@RequestBody AutoDTO autoDTO) {
        autoService.updateAuto(autoDTO);
    }

    @GetMapping("/{id}")
    public AutoDTO getAutoById(@PathVariable int id) {
        return autoService.getAuto(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuto(@PathVariable int id) {
        autoService.deleteAuto(id);
    }

    @GetMapping("/filterDate")
    public ResponseEntity<List<AutoDTO>> getDataRange(@RequestParam("inizio") String inizio, @RequestParam("fine") String fine) {
        List<AutoDTO> autoDisponibili = autoService.getDataRange(LocalDate.parse(inizio), LocalDate.parse(fine));
        return ResponseEntity.ok(autoDisponibili);
    }

}

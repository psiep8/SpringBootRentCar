package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import com.example.springbootrentcar.exception.ResourceNotFoundException;
import com.example.springbootrentcar.repository.AutoRepository;
import com.example.springbootrentcar.service.AutoService;
//import com.example.springbootrentcar.specifications.DateSpecifications;
import com.example.springbootrentcar.specifications.DateSpecifications;
import com.example.springbootrentcar.specifications.FieldSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoRepository autoRepository;

    @Transactional
    @Override
    public void updateAuto(Auto auto) {
        autoRepository.save(auto);
    }

    @Transactional
    @Override
    public void deleteAuto(Auto auto) {
        autoRepository.delete(auto);
    }

    @Override
    public List<Auto> getAutoList() {
        return autoRepository.findAll();
    }

    @Override
    public Auto getAuto(int id) {
        return autoRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Prenotazione non esiste con id:" + id)));
    }

    @Override
    public List<Auto> getDataRange(LocalDate inizio, LocalDate fine) {
        DateSpecifications ds = new DateSpecifications(inizio, fine);
        return autoRepository.findAll(ds);
    }
}

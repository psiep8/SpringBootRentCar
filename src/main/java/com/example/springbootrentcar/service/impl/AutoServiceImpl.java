package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.repository.AutoRepository;
import com.example.springbootrentcar.service.AutoService;
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
    public Optional<Auto> getAuto(int id) {
        return autoRepository.findById(id);
    }

   /* @Override
    public List<Auto> getDataRange(LocalDate inizio, LocalDate fine) {
        return autoRepository.getDataRange(inizio, fine);
    }*/
}

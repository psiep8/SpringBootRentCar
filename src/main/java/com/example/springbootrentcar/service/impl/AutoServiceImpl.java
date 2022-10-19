package com.example.springbootrentcar.service.impl;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.exception.ResourceNotFoundException;
import com.example.springbootrentcar.mapper.AutoMapper;
import com.example.springbootrentcar.repository.AutoRepository;
import com.example.springbootrentcar.service.AutoService;
//import com.example.springbootrentcar.specifications.DateSpecifications;
import com.example.springbootrentcar.specifications.DateSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoRepository autoRepository;

    private final AutoMapper mapper;

    @Transactional
    @Override
    public void updateAuto(AutoDTO autoDTO) {
        autoRepository.save(mapper.fromDTOtoEntity(autoDTO));
    }

    @Transactional
    @Override
    public void deleteAuto(AutoDTO autoDTO) {
        autoRepository.delete(mapper.fromDTOtoEntity(autoDTO));
    }

    @Override
    public List<AutoDTO> getAutoList() {
        List<Auto> autos = autoRepository.findAll();
        return mapper.getAllAutoDTO(autos);
    }

    @Override
    public AutoDTO getAuto(int id) {
        return mapper.fromEntityToDTO(autoRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Prenotazione non esiste con id:" + id))));
    }

    @Override
    public List<AutoDTO> getDataRange(LocalDate inizio, LocalDate fine) {
        DateSpecifications ds = new DateSpecifications(inizio, fine);
        return mapper.getAllAutoDTO(autoRepository.findAll(ds));
    }
}

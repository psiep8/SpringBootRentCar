package com.example.springbootrentcar.service;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.entity.Auto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AutoService {
    void updateAuto(AutoDTO autoDTO);

    void deleteAuto(int id);

    List<AutoDTO> getAutoList();

    AutoDTO getAuto(int id);

    List<AutoDTO> getDataRange(LocalDate inizio, LocalDate fine);

}

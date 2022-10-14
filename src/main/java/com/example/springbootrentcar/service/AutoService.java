package com.example.springbootrentcar.service;

import com.example.springbootrentcar.entity.Auto;

import java.time.LocalDate;
import java.util.List;

public interface AutoService {
    void updateAuto(Auto auto);

    void deleteAuto(Auto auto);

    List<Auto> getAutoList();

    Auto getAuto(int id);

    List<Auto> getDataRange(LocalDate inizio, LocalDate fine);

}

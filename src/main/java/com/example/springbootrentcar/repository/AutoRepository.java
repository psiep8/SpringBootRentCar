package com.example.springbootrentcar.repository;

import com.example.springbootrentcar.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Integer> {

    List<Auto> getDataRange(LocalDate inizio, LocalDate fine);


}

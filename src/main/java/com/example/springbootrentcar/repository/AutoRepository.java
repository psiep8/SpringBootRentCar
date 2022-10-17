package com.example.springbootrentcar.repository;

import com.example.springbootrentcar.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {

    //List<Auto> getDataRange(LocalDate inizio, LocalDate fine);


}

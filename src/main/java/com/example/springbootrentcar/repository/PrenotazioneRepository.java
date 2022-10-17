package com.example.springbootrentcar.repository;

import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

}

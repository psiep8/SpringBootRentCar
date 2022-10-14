package com.example.springbootrentcar.repository;

import com.example.springbootrentcar.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    Utente getUserByEmail(String email);
    
    List<String> getColumn(String campo, String filter);


}

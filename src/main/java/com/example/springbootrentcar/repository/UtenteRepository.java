package com.example.springbootrentcar.repository;

import com.example.springbootrentcar.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Integer>, JpaSpecificationExecutor<Utente> {

    Utente getUserByEmail(String email);

    List<String> getColumn(String campo, String filter);


}

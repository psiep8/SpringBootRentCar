package com.example.springbootrentcar.repository;

import com.example.springbootrentcar.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UtenteRepository extends JpaRepository<Utente, Integer>, JpaSpecificationExecutor<Utente> {

    Utente getUserByEmail(String email);

    // List<Utente> getColumn(String campo, String filter);


}

package com.example.springbootrentcar.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utente", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
public class Utente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idUtente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Column(name = "customer")
    private boolean customer;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "utente", orphanRemoval = true)
    @JsonManagedReference
    private List<Prenotazione> prenotazioniFromUtenteItems;

}

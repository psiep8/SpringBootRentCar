package com.example.springbootrentcar.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
@Getter
@Setter
public class Prenotazione implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    @Column(name = "approvata")
    private boolean approvata;

    @ManyToOne
    @JoinColumn(name = "auto_id", referencedColumnName = "id")
    @JsonBackReference
    private Auto auto;

    @ManyToOne
    @JoinColumn(name = "utente_id", referencedColumnName = "id")
    @JsonBackReference
    private Utente utente;

}

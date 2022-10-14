package com.example.springbootrentcar.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
@Data
public class Prenotazione implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dataInizio")
    @Temporal(TemporalType.DATE)
    private LocalDate dataInizio;

    @Column(name = "dataFine")
    @Temporal(TemporalType.DATE)
    private LocalDate dataFine;

    @Column(name = "approvata")
    private boolean approvata;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "auto", referencedColumnName = "idAuto")
    @JsonBackReference
    private Auto auto;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "utente", referencedColumnName = "idUtente")
    @JsonBackReference
    private Utente utente;

}

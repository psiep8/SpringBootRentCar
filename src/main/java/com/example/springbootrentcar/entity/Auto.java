package com.example.springbootrentcar.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "auto")
@Getter
@Setter
public class Auto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idAuto;

    @Column(name = "marca")
    private String marca;

    @Column(name = "cilindrata")
    private int cilindrata;

    @Column(name = "modello")
    private String modello;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "auto", orphanRemoval = true)
    @JsonManagedReference
    private List<Prenotazione> prenotazioniFromAutoItems;

}

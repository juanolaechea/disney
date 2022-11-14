package com.example.disney.domine;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Personajes")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonaje")
    private Integer idPersonaje;
    @Column(name = "nombre")
    private String name;
    @Column(name = "edad")
    private Integer age;
    @Column(name = "peso")
    private Float weight;
    @Column(name = "hsitoria")
    private String history;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_peliculasSeries" )
    PeliculaSerie peliculasSeries;




}

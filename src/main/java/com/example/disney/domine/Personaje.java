package com.example.disney.domine;


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
class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPersonaje")
    private Integer idPersonaje;
    @Column(name ="name" )
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name ="weight")
    private Float weight;
    @Column(name = "history")
    private String history;




}

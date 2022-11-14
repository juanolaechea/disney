package com.example.disney.domine;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGenero")
    private Integer idGenero;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "genero")
    List<PeliculaSerie> peliculaSeries= new ArrayList<PeliculaSerie>();







}

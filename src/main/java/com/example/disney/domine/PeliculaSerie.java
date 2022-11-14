package com.example.disney.domine;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "peliculasSeries")
public class PeliculaSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPeliculaSerie")
    private Integer idPeliculaSerie;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;
    @Column(name = "calification")
    @Enumerated(EnumType.STRING)
    private CalificationValue calificacion;

    @OneToMany(mappedBy = "peliculasSeries")
    List<Personaje> personajes= new ArrayList<Personaje>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_genero" )
    Genero genero;




}

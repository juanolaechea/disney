package com.example.disney.dto;


import com.example.disney.domine.PeliculaSerie;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DtoPersonaje {

    private Integer idPersonaje;
    private String name;
    private Integer age;
    private Float weight;
    private String history;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    PeliculaSerie peliculasSeries;
}

package com.example.disney.service;

import com.example.disney.domine.PeliculaSerie;
import com.example.disney.persistence.PeliculasSerieRepository;
import com.example.disney.utils.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.example.disney.constants.ConstantsController.BASE_URL;
import static com.example.disney.constants.ConstantsController.URL_PELICULAS;
import static com.example.disney.utils.EntityURLBuilder.buildURL;

@Service
public class PeliculaSerieService {

    private final PeliculasSerieRepository peliculasSerieRepository;

    @Autowired
    public PeliculaSerieService(PeliculasSerieRepository peliculasSerieRepository) {
        this.peliculasSerieRepository = peliculasSerieRepository;
    }


    public PostResponse createPelicula(PeliculaSerie peliculaSerie) {
        this.peliculasSerieRepository.save(peliculaSerie);
        return PostResponse.builder().httpStatus(HttpStatus.CREATED)
                .link(buildURL(BASE_URL+URL_PELICULAS,peliculaSerie.getIdPeliculaSerie().toString()))
                .build();
    }
}

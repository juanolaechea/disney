package com.example.disney.controller;

import com.example.disney.domine.PeliculaSerie;
import com.example.disney.service.PeliculaSerieService;
import com.example.disney.utils.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.disney.constants.ConstantsController.BASE_URL;
import static com.example.disney.constants.ConstantsController.URL_PELICULAS;

@Controller
@RestController
@RequestMapping(BASE_URL)
public class PeliculaSerieController {

    private final PeliculaSerieService peliculaSerieService;


    @Autowired
    public PeliculaSerieController(PeliculaSerieService peliculaSerieService) {
        this.peliculaSerieService = peliculaSerieService;
    }

    @PostMapping(path = URL_PELICULAS)
    public PostResponse createPelicula(@RequestBody PeliculaSerie peliculaSerie){
        return peliculaSerieService.createPelicula(peliculaSerie);

    }
}

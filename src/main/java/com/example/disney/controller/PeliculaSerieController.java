package com.example.disney.controller;

import com.example.disney.domine.PeliculaSerie;
import com.example.disney.service.PeliculaSerieService;
import com.example.disney.utils.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(path = URL_PELICULAS)
    public ResponseEntity<List<PeliculaSerie>> getAll(){
        List<PeliculaSerie>peliculaSeries = this.peliculaSerieService.getAll();
        return peliculaSeries.isEmpty() ?ResponseEntity.noContent().build() : ResponseEntity.ok(peliculaSeries);

    }
    @GetMapping(path = URL_PELICULAS + "/{idPelicula}")
   public PeliculaSerie getById(@PathVariable ("idPelicula") Integer idPelicula){
        return this.peliculaSerieService.getById(idPelicula);

    }
    @DeleteMapping(path = URL_PELICULAS + "/{idPelicula}")
    public void deleteById(@PathVariable("idPelicula") Integer idPelicula){
        this.peliculaSerieService.deleteById(idPelicula);
    }
}

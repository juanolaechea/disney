package com.example.disney.controller;

import com.example.disney.domine.Personaje;
import com.example.disney.service.PersonajeService;
import com.example.disney.utils.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.disney.constants.ConstantsController.BASE_URL;
import static com.example.disney.constants.ConstantsController.URL_PERSONAJE;


@Controller
@RestController
@RequestMapping(BASE_URL)
public class PersonajeControlles {

    private final PersonajeService personajeService;

    @Autowired
    public PersonajeControlles(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @PostMapping(URL_PERSONAJE)
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse createPersonaje(@RequestBody Personaje personaje){
        return personajeService.createPersonaje(personaje);
    }

    @GetMapping(URL_PERSONAJE)
    public ResponseEntity<List<Personaje>>getAll(){
        List<Personaje>personajes= this.personajeService.getAll();
        return personajes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(personajes);
    }


    @GetMapping(URL_PERSONAJE +"/{idPersonaje}")
    public Personaje getClientById(@PathVariable("idPersonaje") Integer idPersonaje){
       return  this.personajeService.getById(idPersonaje);
    }

    @DeleteMapping(URL_PERSONAJE+"/{idPersonje}")
    public void deletePersonaje(@PathVariable ("idPersonaje") Integer idPersonaje){

        this.personajeService.deletePersonje(idPersonaje);
    }


}

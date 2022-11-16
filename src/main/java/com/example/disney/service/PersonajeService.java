package com.example.disney.service;

import com.example.disney.domine.Personaje;
import com.example.disney.persistence.PersonajeRepository;
import com.example.disney.utils.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.print.DocFlavor;

import java.util.List;

import static com.example.disney.constants.ConstantsController.BASE_URL;
import static com.example.disney.constants.ConstantsController.URL_PERSONAJE;
import static com.example.disney.utils.EntityURLBuilder.buildURL;

@Service
public class PersonajeService {

    private final PersonajeRepository personajeRepository;


    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public PostResponse createPersonaje(Personaje personaje) {
          this.personajeRepository.save(personaje);
          return PostResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                  .link(buildURL(BASE_URL+URL_PERSONAJE,personaje.getIdPersonaje().toString()))
                .build();
    }

    public List<Personaje> getAll() {
            return personajeRepository.findAll();
    }


    public void deletePersonje(Integer idPersonaje) {

        this.personajeRepository.deleteById(idPersonaje);
    }

    public Personaje getById(Integer idPersonaje) {
        return this.personajeRepository.findById(idPersonaje)
                .orElseThrow(()-> new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Personaje not exist"));

    }
}

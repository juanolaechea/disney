package com.example.disney.controller;

import com.example.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.disney.constants.ConstantsController.BASE_URL;

@Controller
@RestController
@RequestMapping(BASE_URL)
public class PersonajeControlles {

    private final PersonajeService personajeService;

    @Autowired
    public PersonajeControlles(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }
}

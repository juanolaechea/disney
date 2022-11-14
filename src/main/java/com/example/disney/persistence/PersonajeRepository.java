package com.example.disney.persistence;

import com.example.disney.domine.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje,Integer> {
}

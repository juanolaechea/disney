package com.example.disney.persistence;

import com.example.disney.domine.PeliculaSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasSerieRepository extends JpaRepository<PeliculaSerie,Integer> {
}

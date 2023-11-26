package com.curso.primeraweb.primeraweb.repository;

import com.curso.primeraweb.primeraweb.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JpaRepository<T,ID>
 * JpaRepository<NombreClaseDondeSeAplicara,TipoDeDatoDelPrimaryKey>
 */

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}

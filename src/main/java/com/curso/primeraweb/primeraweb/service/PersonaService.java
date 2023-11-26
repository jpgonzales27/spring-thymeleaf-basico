package com.curso.primeraweb.primeraweb.service;

import com.curso.primeraweb.primeraweb.entities.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> obtenerTodas();
    Persona obtenerPersonaPorID(Long id);
    Persona crearPersona(Persona persona);
    Persona actualizarPersona(Long id,Persona persona);
    void eliminarPersona(Long id);
    Long contarPersonas();
}

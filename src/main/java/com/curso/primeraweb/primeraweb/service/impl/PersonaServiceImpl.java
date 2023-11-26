package com.curso.primeraweb.primeraweb.service.impl;

import com.curso.primeraweb.primeraweb.entities.Persona;
import com.curso.primeraweb.primeraweb.repository.PersonaRepository;
import com.curso.primeraweb.primeraweb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> obtenerTodas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona obtenerPersonaPorID(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
        Persona personaBD = personaRepository.findById(id).orElse(null);
        if(personaBD != null) {
            personaBD.setNombre(persona.getNombre());
            personaBD.setEdad(persona.getEdad());
            return personaRepository.save(personaBD);
        }
        return null;
    }

    @Override
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Long contarPersonas() {
        return personaRepository.count();
    }
}

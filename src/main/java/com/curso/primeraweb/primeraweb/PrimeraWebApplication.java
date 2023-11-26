package com.curso.primeraweb.primeraweb;

import com.curso.primeraweb.primeraweb.repository.PersonaRepository;
import com.curso.primeraweb.primeraweb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeraWebApplication {

    /**
     * Inyectando el repository
     */
    @Autowired
    public PersonaRepository personaRepository;

    @Autowired
    private PersonaService personaService;

    public static void main(String[] args) {
        SpringApplication.run(PrimeraWebApplication.class, args);
    }
}

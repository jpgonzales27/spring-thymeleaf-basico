package com.curso.primeraweb.primeraweb.controller;

import com.curso.primeraweb.primeraweb.entities.Persona;
import com.curso.primeraweb.primeraweb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    /**
     * Clase Model - Se utiliza para transferir objetos del controller a la vista
     */
    @GetMapping
    public String listarPersoans(Model model) {
        List<Persona> personas = personaService.obtenerTodas();
        /**
         * model.addAttribute(key,value);
         */
        model.addAttribute("listaPersonas", personas);
        return "listar";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioDeNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("accion", "/personas/nueva");
        return "formulario";
    }

    /**
     * @ModelAttribute - obtiene los campos q pasan de la vista por el th:field
     * que escribiste en el formulario
     */
    @PostMapping("/nueva")
    public String guardarNuevaPersona(@ModelAttribute Persona persona) {
        personaService.crearPersona(persona);
        return "redirect:/personas";
    }

    /**
     * @PathVariable - anotacion que nos permite pasar variables a la URL en este caso tomara el valor
     * del id que estamos pasando entre {id}
     * @ModelAttribute Persona persona = esta linea nos permite obtener los datos de esa persona que estamos
     * queriendo actualizar
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, @ModelAttribute Persona persona, Model model) {
        model.addAttribute("persona", persona);
        model.addAttribute("accion", "/personas/editar/" + id);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona, Model model) {
        personaService.actualizarPersona(id, persona);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }
}

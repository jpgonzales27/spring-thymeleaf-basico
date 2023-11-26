package com.curso.primeraweb.primeraweb.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_personas")
@Data //Crea los getters and setters
@AllArgsConstructor // Crea constructor con todos los atributos
@NoArgsConstructor // Crea constructor con sin atributos
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incrimentar el id automaticamente
    private Long id;
    private String nombre;
    private int edad;
}

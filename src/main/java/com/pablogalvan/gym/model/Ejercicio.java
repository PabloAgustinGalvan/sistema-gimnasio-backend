package com.pablogalvan.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @OneToMany(mappedBy = "ejercicio")
    @JsonIgnore
    private List<RutinaEjercicio> rutinas = new ArrayList<>();

    public Ejercicio(String nombre){
        this.nombre = nombre;
    }

    public Ejercicio() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<RutinaEjercicio> getRutinas() {
        return rutinas;
    }

    public void setRutinas(List<RutinaEjercicio> rutinas) {
        this.rutinas = rutinas;
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "Nombre='" + nombre + '\'' +
                '}';
    }
}





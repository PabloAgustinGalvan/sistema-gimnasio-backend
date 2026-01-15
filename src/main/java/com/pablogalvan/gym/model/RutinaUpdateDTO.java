package com.pablogalvan.gym.model;

import java.util.List;

public class RutinaUpdateDTO {
    private String nombre;
    private List<RutinaEjercicioDTO> ejercicios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<RutinaEjercicioDTO> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<RutinaEjercicioDTO> ejercicios) {
        this.ejercicios = ejercicios;
    }
}

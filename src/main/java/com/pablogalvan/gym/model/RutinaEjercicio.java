package com.pablogalvan.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class RutinaEjercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---- relación con Rutina ----
    @ManyToOne(optional = false)
    @JoinColumn(name = "rutina_id")
    @JsonIgnore
    private Rutina rutina;

    // ---- relación con Ejercicio ----
    @ManyToOne(optional = false)
    @JoinColumn(name = "ejercicio_id")
    private Ejercicio ejercicio;

    @Min(value = 1, message = "Las series deben ser minimo 1")
    private Integer series;
    @Min(value = 1,message = "Las repeticiones deben ser al menos 1")
    private Integer repeticiones;
    private String descripcion;


    public RutinaEjercicio(Rutina rutina, Ejercicio ejercicio, int series, int repeticiones, String descripcion) {
        this.rutina = rutina;
        this.ejercicio = ejercicio;
        this.series = series;
        this.repeticiones = repeticiones;
        this.descripcion = descripcion;
    }

    public RutinaEjercicio() {

    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

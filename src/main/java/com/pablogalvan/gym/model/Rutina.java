package com.pablogalvan.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "rutina")
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(
            mappedBy = "rutina",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RutinaEjercicio> ejercicios = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "socio_id")
    @JsonIgnore
    private Socio socio;

    public Rutina(String nombre) {
        this.nombre = nombre;
        this.ejercicios = new ArrayList<>();
    }

    public Rutina() {

    }


    public void agregarEjercicio(RutinaEjercicio re) {
        ejercicios.add(re);
        re.setRutina(this);
    }

    public List<RutinaEjercicio> getEjercicios() {
        return ejercicios;
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

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public void setEjercicios(List<RutinaEjercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    @Override
    public String toString() {
        return "Rutina{" +
                "nombre='" + nombre + '\'' +
                ", ejercicios=" + ejercicios +
                '}';
    }
}







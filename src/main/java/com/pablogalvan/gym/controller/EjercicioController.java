package com.pablogalvan.gym.controller;

import com.pablogalvan.gym.model.Ejercicio;
import com.pablogalvan.gym.service.EjercicioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejercicios")
public class EjercicioController {

    private final EjercicioService ejercicioService;

    public EjercicioController(EjercicioService ejercicioService) {
        this.ejercicioService = ejercicioService;
    }

    @PostMapping
    public Ejercicio crear(@Valid @RequestBody Ejercicio ejercicio) {
        return ejercicioService.guardar(ejercicio);
    }

    @GetMapping
    public List<Ejercicio> listar() {
        return ejercicioService.listar();
    }


}

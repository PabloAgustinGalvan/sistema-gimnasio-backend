package com.pablogalvan.gym.service;

import com.pablogalvan.gym.model.Ejercicio;
import com.pablogalvan.gym.model.Socio;
import com.pablogalvan.gym.repository.EjercicioRepository;
import com.pablogalvan.gym.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {
    private final EjercicioRepository repo;

    public EjercicioService(EjercicioRepository repo) {
        this.repo = repo;
    }

    public List<Ejercicio> listar() {
        return repo.findAll();
    }
    public Ejercicio guardar(Ejercicio ejercicio) {
        return repo.save(ejercicio);
    }

}

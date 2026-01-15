package com.pablogalvan.gym.repository;

import com.pablogalvan.gym.model.Ejercicio;
import com.pablogalvan.gym.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {}

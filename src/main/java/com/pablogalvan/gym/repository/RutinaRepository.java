package com.pablogalvan.gym.repository;

import com.pablogalvan.gym.model.Rutina;
import com.pablogalvan.gym.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinaRepository extends JpaRepository<Rutina, Long> {
    List<Rutina> findBySocioId(Long socioId);
}




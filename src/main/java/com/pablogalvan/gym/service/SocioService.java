package com.pablogalvan.gym.service;

import com.pablogalvan.gym.model.Socio;
import com.pablogalvan.gym.model.SocioUpdateDTO;
import com.pablogalvan.gym.repository.SocioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SocioService {
    private final SocioRepository repo;

    public SocioService(SocioRepository repo) {
        this.repo = repo;
    }

    public List<Socio> listar() {
        return repo.findAll();
    }

    public Socio guardar(Socio socio) {
        return repo.save(socio);
    }
    @Transactional
    public Socio findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));
    }

    public Socio actualizarSocio(Long id, SocioUpdateDTO dto) {

        Socio socio = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        if (dto.getNombre() != null) {
            socio.setNombre(dto.getNombre());
        }

        if (dto.getApellido() != null) {
            socio.setApellido(dto.getApellido());
        }

        if (dto.getTelefono() != null) {
            socio.setTelefono(dto.getTelefono());
        }

        if (dto.getActivo() != null) {

            // si pasa de false/null a true se considera pago
            if (dto.getActivo() && !socio.isActivo()) {
                socio.setFechaInscripcion(LocalDate.now());
            }

            socio.setActivo(dto.getActivo());
        }
            // pasa de activo a inactivo
            if (!dto.getActivo()) {
                socio.setActivo(false);
            }

        return repo.save(socio);
    }
    public void borrarSocio(Long id) {
        Socio socio = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));
        repo.delete(socio);
    }


}

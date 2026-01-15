package com.pablogalvan.gym.service;

import com.pablogalvan.gym.model.*;
import com.pablogalvan.gym.repository.EjercicioRepository;
import com.pablogalvan.gym.repository.RutinaRepository;
import com.pablogalvan.gym.repository.SocioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutinaService {

    private final RutinaRepository rutinaRepository;
    private final EjercicioRepository ejercicioRepository;
    private final SocioRepository socioRepository;

    public RutinaService(



    RutinaRepository rutinaRepository,
    EjercicioRepository ejercicioRepository,
    SocioRepository socioRepository
    ) {
        this.rutinaRepository = rutinaRepository;
        this.ejercicioRepository = ejercicioRepository;
        this.socioRepository = socioRepository;
    }


    @Transactional
    public Rutina crearRutina(Long socioId, Rutina rutina) {

        Socio socio = socioRepository.findById(socioId)
                .orElseThrow(() -> new RuntimeException("Socio no existe"));

        rutina.setSocio(socio);
        socio.getRutinas().add(rutina);

        for (RutinaEjercicio re : rutina.getEjercicios()) {

            // traer ejercicio real desde BD
            Long ejercicioId = re.getEjercicio().getId();

            Ejercicio ejercicio = ejercicioRepository.findById(ejercicioId)
                    .orElseThrow(() -> new RuntimeException("Ejercicio no existe"));

            re.setEjercicio(ejercicio);
            re.setRutina(rutina);
        }

        return rutinaRepository.save(rutina);
    }

    public List<Rutina> obtenerRutinasDeSocio(Long socioId) {

        // Valido que el socio exista
        if (!socioRepository.existsById(socioId)) {
            throw new RuntimeException("Socio no encontrado con id: " + socioId);
        }

        // Busco las rutinas del socio
        return rutinaRepository.findBySocioId(socioId);
    }

    public Rutina actualizarRutina(Long rutinaId, RutinaUpdateDTO dto) {

        Rutina rutina = rutinaRepository.findById(rutinaId)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        if (dto.getNombre() != null) {
            rutina.setNombre(dto.getNombre());
        }

        if (dto.getEjercicios() != null) {

            rutina.getEjercicios().clear();

            for (RutinaEjercicioDTO eDto : dto.getEjercicios()) {

                Ejercicio ejercicio = ejercicioRepository.findById(eDto.getEjercicioId())
                        .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));

                RutinaEjercicio re = new RutinaEjercicio();
                re.setRutina(rutina);
                re.setEjercicio(ejercicio);
                re.setSeries(eDto.getSeries());
                re.setRepeticiones(eDto.getRepeticiones());
                re.setDescripcion(eDto.getDescripcion());

                rutina.getEjercicios().add(re);
            }
        }

        return rutinaRepository.save(rutina);
    }

    public List<Rutina> findAll() {
        return rutinaRepository.findAll();
    }

    public void borrarRutina(Long id){
        Rutina r = rutinaRepository.findById(id).orElseThrow(() -> new RuntimeException("Rutina no encontrada"));
        rutinaRepository.delete(r);
    }



}

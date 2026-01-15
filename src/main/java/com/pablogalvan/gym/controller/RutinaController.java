package com.pablogalvan.gym.controller;


import com.pablogalvan.gym.model.Rutina;
import com.pablogalvan.gym.model.RutinaUpdateDTO;
import com.pablogalvan.gym.service.RutinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rutinas")
public class RutinaController {

    private final RutinaService rutinaService;

    public RutinaController(RutinaService rutinaService) {
        this.rutinaService = rutinaService;
    }

    // GET /rutinas
    @GetMapping
    public List<Rutina> obtenerTodas() {
        return rutinaService.findAll();
    }


    // POST /rutinas/socio/{socioId}
    @PostMapping("/socio/{socioId}")
    public Rutina crearRutina(
            @PathVariable Long socioId,
            @RequestBody Rutina rutina
    ) {
        return rutinaService.crearRutina(socioId, rutina);
    }

    @GetMapping("/{id}/rutinas")
    public List<Rutina> rutinasDeSocio(@PathVariable Long id) {
        return rutinaService.obtenerRutinasDeSocio(id);
    }

    @PutMapping("/{id}")
    public Rutina actualizarRutina(
            @PathVariable Long id,
            @RequestBody RutinaUpdateDTO dto
    ) {
        return rutinaService.actualizarRutina(id, dto);
    }

    @DeleteMapping("/{id}")
    public void borrarRutina(@PathVariable Long id){
        rutinaService.borrarRutina(id);
    }
}

package com.pablogalvan.gym.controller;

import com.pablogalvan.gym.model.Socio;
import com.pablogalvan.gym.model.SocioUpdateDTO;
import com.pablogalvan.gym.service.SocioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @PostMapping
    public Socio crear(@Valid @RequestBody Socio socio) {
        return socioService.guardar(socio);
    }

    @GetMapping
    public List<Socio> listar() {
        return socioService.listar();
    }

    // GET /socios/{id}
    @GetMapping("/{id}")
    public Socio obtenerPorId(@PathVariable Long id) {
        return socioService.findById(id);
    }


    @PutMapping("/{id}")
    public Socio actualizarSocio(
            @PathVariable Long id,
            @RequestBody SocioUpdateDTO dto
    ) {
        return socioService.actualizarSocio(id, dto);
    }

    @DeleteMapping("{id}")
    public void borrarSocio(@PathVariable Long id

    ){
        socioService.borrarSocio(id);
    }
}

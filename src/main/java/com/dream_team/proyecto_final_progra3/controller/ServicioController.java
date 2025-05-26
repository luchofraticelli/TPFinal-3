package com.dream_team.proyecto_final_progra3.controller;

import com.dream_team.proyecto_final_progra3.entity.CostoServicio;
import com.dream_team.proyecto_final_progra3.service.CostoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {
    @Autowired
    private CostoServicioService servicioService;

    @GetMapping
    public List<CostoServicio> getAllServicios() {
        return servicioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostoServicio> getServicioById(@PathVariable Long id) {
        Optional<CostoServicio> servicio = servicioService.findById(id);
        return servicio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<CostoServicio> getServicioByNombre(@PathVariable String nombre) {
        Optional<CostoServicio> servicio = servicioService.findByNombre(nombre);
        return servicio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CostoServicio createServicio(@RequestBody CostoServicio servicio) {
        return servicioService.save(servicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostoServicio> updateServicio(@PathVariable Long id, @RequestBody CostoServicio servicioDetails) {
        Optional<CostoServicio> servicio = servicioService.findById(id);
        if (servicio.isPresent()) {
            CostoServicio updatedServicio = servicio.get();
            // Actualizar campos aquí
            return ResponseEntity.ok(servicioService.save(updatedServicio));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Long id) {
        servicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
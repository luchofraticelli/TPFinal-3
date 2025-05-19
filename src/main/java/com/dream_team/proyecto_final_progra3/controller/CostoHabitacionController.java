package com.dream_team.proyecto_final_progra3.controller;

import com.dream_team.proyecto_final_progra3.entity.CostoHabitacion;
import com.dream_team.proyecto_final_progra3.service.CostoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/costos-habitacion")
public class CostoHabitacionController {
    @Autowired
    private CostoHabitacionService costoHabitacionService;

    @GetMapping
    public List<CostoHabitacion> getAllCostosHabitacion() {
        return costoHabitacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostoHabitacion> getCostoHabitacionById(@PathVariable Long id) {
        Optional<CostoHabitacion> costoHabitacion = costoHabitacionService.findById(id);
        return costoHabitacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<CostoHabitacion> getCostoByTipoHabitacion(@PathVariable String tipo) {
        CostoHabitacion costoHabitacion = costoHabitacionService.findByTipoHabitacion(tipo);
        if (costoHabitacion != null) {
            return ResponseEntity.ok(costoHabitacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CostoHabitacion createCostoHabitacion(@RequestBody CostoHabitacion costoHabitacion) {
        return costoHabitacionService.save(costoHabitacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostoHabitacion> updateCostoHabitacion(@PathVariable Long id, @RequestBody CostoHabitacion costoHabitacionDetails) {
        Optional<CostoHabitacion> costoHabitacion = costoHabitacionService.findById(id);
        if (costoHabitacion.isPresent()) {
            CostoHabitacion updatedCostoHabitacion = costoHabitacion.get();
            // Actualizar campos aquí
            return ResponseEntity.ok(costoHabitacionService.save(updatedCostoHabitacion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCostoHabitacion(@PathVariable Long id) {
        costoHabitacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
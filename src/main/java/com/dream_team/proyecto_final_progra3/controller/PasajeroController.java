package com.dream_team.proyecto_final_progra3.controller;

import com.dream_team.proyecto_final_progra3.entity.Pasajero;
import com.dream_team.proyecto_final_progra3.service.PasajeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pasajeros")
@RequiredArgsConstructor
public class PasajeroController {
    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping
    public List<Pasajero> getAllPasajeros() {
        return pasajeroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> getPasajeroById(@PathVariable Long id) {
        Optional<Pasajero> pasajero = pasajeroService.findById(id);
        return pasajero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pasajero createPasajero(@RequestBody Pasajero pasajero) {
        return pasajeroService.save(pasajero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> updatePasajero(@PathVariable Long id, @RequestBody Pasajero pasajeroDetails) {
        Optional<Pasajero> pasajero = pasajeroService.findById(id);
        if (pasajero.isPresent()) {
            Pasajero updatedPasajero = pasajero.get();
            // Actualizar campos aquí
            return ResponseEntity.ok(pasajeroService.save(updatedPasajero));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePasajero(@PathVariable Long id) {
        pasajeroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
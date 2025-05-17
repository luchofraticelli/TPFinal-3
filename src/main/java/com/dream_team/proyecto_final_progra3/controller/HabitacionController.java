package com.dream_team.proyecto_final_progra3.controller;

import com.dream_team.proyecto_final_progra3.entity.Habitacion;
import com.dream_team.proyecto_final_progra3.service.HabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {
    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public List<Habitacion> getAllHabitaciones() {
        return habitacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> getHabitacionById(@PathVariable Long id) {
        Optional<Habitacion> habitacion = habitacionService.findById(id);
        return habitacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<Habitacion> getHabitacionByNumero(@PathVariable String numero) {
        Habitacion habitacion = habitacionService.findByNumeroHabitacion(numero);
        if (habitacion != null) {
            return ResponseEntity.ok(habitacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estado/{estado}")
    public List<Habitacion> getHabitacionesByEstado(@PathVariable String estado) {
        return habitacionService.findByEstado(estado);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Habitacion> getHabitacionesByTipo(@PathVariable String tipo) {
        return habitacionService.findByTipoHabitacion(tipo);
    }

    @PostMapping
    public Habitacion createHabitacion(@RequestBody Habitacion habitacion) {
        return habitacionService.save(habitacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> updateHabitacion(@PathVariable Long id, @RequestBody Habitacion habitacionDetails) {
        Optional<Habitacion> habitacion = habitacionService.findById(id);
        if (habitacion.isPresent()) {
            Habitacion updatedHabitacion = habitacion.get();
            // Actualizar campos aquí
            return ResponseEntity.ok(habitacionService.save(updatedHabitacion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitacion(@PathVariable Long id) {
        habitacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
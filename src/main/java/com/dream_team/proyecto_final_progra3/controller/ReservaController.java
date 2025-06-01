package com.dream_team.proyecto_final_progra3.controller;

import com.dream_team.proyecto_final_progra3.entity.Reserva;
import com.dream_team.proyecto_final_progra3.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaService.findById(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/fechas")
    public List<Reserva> getReservasBetweenDates(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fin) {
        return reservaService.findByFechaInicioBetween(inicio, fin);
    }

    @GetMapping("/pasajero/{pasajeroId}")
    public List<Reserva> getReservasByPasajero(@PathVariable Long pasajeroId) {
        return reservaService.findByPasajeroId(pasajeroId);
    }

    @GetMapping("/habitacion/{habitacionId}")
    public List<Reserva> getReservasByHabitacion(@PathVariable Long habitacionId) {
        return reservaService.findByHabitacionId(habitacionId);
    }

    @GetMapping("/estado/{estado}")
    public List<Reserva> getReservasByEstado(@PathVariable String estado) {
        return reservaService.findByEstado(estado);
    }

    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reservaDetails) {
        Optional<Reserva> reserva = reservaService.findById(id);
        if (reserva.isPresent()) {
            Reserva updatedReserva = reserva.get();
            // Actualizar campos aquí
            return ResponseEntity.ok(reservaService.save(updatedReserva));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
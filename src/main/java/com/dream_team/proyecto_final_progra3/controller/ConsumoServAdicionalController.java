package com.dream_team.proyecto_final_progra3.controller;

import com.dream_team.proyecto_final_progra3.dto.ConsumoServAdicionalDTO;
import com.dream_team.proyecto_final_progra3.entity.ConsumoServAdicional;
import com.dream_team.proyecto_final_progra3.entity.Reserva;
import com.dream_team.proyecto_final_progra3.entity.ServAdicional;
import com.dream_team.proyecto_final_progra3.service.ConsumoServAdicionalService;
import com.dream_team.proyecto_final_progra3.service.ReservaService;
import com.dream_team.proyecto_final_progra3.service.ServAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/consumos-servicios-adicionales")
public class ConsumoServAdicionalController {

    @Autowired
    private ConsumoServAdicionalService consumoServAdicionalService;
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private ServAdicionalService servAdicionalService;

    @GetMapping("/reserva/{reservaId}")
    public ResponseEntity<List<ConsumoServAdicionalDTO>> listarPorReserva(@PathVariable Long reservaId) {
        List<ConsumoServAdicionalDTO> dtos = consumoServAdicionalService.findByReservaId(reservaId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ConsumoServAdicionalDTO dto) {
        Reserva reserva = reservaService.findById(dto.getReservaId())
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        ServAdicional adicional = servAdicionalService.findById(dto.getServAdicionalId())
                .orElseThrow(() -> new RuntimeException("Servicio adicional no encontrado"));

        ConsumoServAdicional consumo = new ConsumoServAdicional();
        consumo.setReserva(reserva);
        consumo.setServAdicional(adicional);
        consumo.setFechaConsumo(dto.getFechaConsumo());
        consumo.setCantidad(dto.getCantidad() != null ? dto.getCantidad() : 1);

        ConsumoServAdicional guardado = consumoServAdicionalService.save(consumo);
        return ResponseEntity.ok(toDTO(guardado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        consumoServAdicionalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Mapper simple
    private ConsumoServAdicionalDTO toDTO(ConsumoServAdicional consumo) {
        ConsumoServAdicionalDTO dto = new ConsumoServAdicionalDTO();
        dto.setId(consumo.getId());
        dto.setReservaId(consumo.getReserva().getId());
        dto.setServAdicionalId(consumo.getServAdicional().getId());
        dto.setFechaConsumo(consumo.getFechaConsumo());
        dto.setCantidad(consumo.getCantidad());
        return dto;
    }
}

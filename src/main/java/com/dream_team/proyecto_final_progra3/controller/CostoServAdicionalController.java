package com.dream_team.proyecto_final_progra3.controller;

import com.dream_team.proyecto_final_progra3.dto.CostoServAdicionalDTO;
import com.dream_team.proyecto_final_progra3.entity.CostoServAdicional;
import com.dream_team.proyecto_final_progra3.entity.ServAdicional;
import com.dream_team.proyecto_final_progra3.service.CostoServAdicionalService;
import com.dream_team.proyecto_final_progra3.service.ServAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/costos-servicio-adicional")
public class CostoServAdicionalController {


    @Autowired
    private CostoServAdicionalService costoServAdicionalService;

    @Autowired
    private ServAdicionalService servAdicionalService;

    @GetMapping
    public ResponseEntity<List<CostoServAdicional>> listarTodos() {
        return ResponseEntity.ok(costoServAdicionalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostoServAdicional> obtenerPorId(@PathVariable Long id) {
        return costoServAdicionalService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Alta con DTO y validación de fechas y solapamiento
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CostoServAdicionalDTO dto) {
        if (dto.getFechaDesde().isAfter(dto.getFechaHasta())) {
            return ResponseEntity.badRequest().body("La fecha desde debe ser anterior o igual a la fecha hasta");
        }
        ServAdicional servAdicional = servAdicionalService.findById(dto.getServAdicionalId())
                .orElseThrow(() -> new RuntimeException("Servicio adicional no encontrado"));

        boolean existeSolapamiento = costoServAdicionalService.existeSolapamiento(
                servAdicional, dto.getFechaDesde(), dto.getFechaHasta(), null);

        if (existeSolapamiento) {
            return ResponseEntity.badRequest().body("Ya existe un costo cargado en ese rango de fechas para este servicio adicional");
        }

        CostoServAdicional costo = new CostoServAdicional();
        costo.setServAdicional(servAdicional);
        costo.setPrecio(dto.getPrecio());
        costo.setFechaDesde(dto.getFechaDesde());
        costo.setFechaHasta(dto.getFechaHasta());

        CostoServAdicional guardado = costoServAdicionalService.save(costo);
        return ResponseEntity.ok(guardado);
    }

    // Modificación con DTO y validación de fechas y solapamiento
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody CostoServAdicionalDTO dto) {
        if (dto.getFechaDesde().isAfter(dto.getFechaHasta())) {
            return ResponseEntity.badRequest().body("La fecha desde debe ser anterior o igual a la fecha hasta");
        }
        ServAdicional servAdicional = servAdicionalService.findById(dto.getServAdicionalId())
                .orElseThrow(() -> new RuntimeException("Servicio adicional no encontrado"));

        boolean existeSolapamiento = costoServAdicionalService.existeSolapamiento(
                servAdicional, dto.getFechaDesde(), dto.getFechaHasta(), id);

        if (existeSolapamiento) {
            return ResponseEntity.badRequest().body("Ya existe un costo cargado en ese rango de fechas para este servicio adicional");
        }

        return costoServAdicionalService.findById(id)
                .map(costo -> {
                    costo.setPrecio(dto.getPrecio());
                    costo.setFechaDesde(dto.getFechaDesde());
                    costo.setFechaHasta(dto.getFechaHasta());
                    costo.setServAdicional(servAdicional);
                    return ResponseEntity.ok(costoServAdicionalService.save(costo));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        costoServAdicionalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consulta del costo vigente para un servicio adicional en una fecha (opcional)
    @GetMapping("/vigente")
    public ResponseEntity<CostoServAdicional> costoVigente(
            @RequestParam Long servAdicionalId,
            @RequestParam String fecha // formato yyyy-MM-dd
    ) {
        ServAdicional servAdicional = servAdicionalService.findById(servAdicionalId)
                .orElseThrow(() -> new RuntimeException("Servicio adicional no encontrado"));
        var localDate = java.time.LocalDate.parse(fecha);

        return costoServAdicionalService.findVigente(servAdicional, localDate)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

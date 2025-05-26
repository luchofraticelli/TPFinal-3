package com.dream_team.proyecto_final_progra3.controller;

import com.dream_team.proyecto_final_progra3.entity.ServAdicional;
import com.dream_team.proyecto_final_progra3.service.ServAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios-adicionales")
public class ServAdicionalController {

    private final ServAdicionalService servAdicionalService;

    @Autowired
    public ServAdicionalController(ServAdicionalService servAdicionalService) {
        this.servAdicionalService = servAdicionalService;
    }

    @GetMapping
    public ResponseEntity<List<ServAdicional>> listar() {
        return ResponseEntity.ok(servAdicionalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServAdicional> obtenerPorId(@PathVariable Long id) {
        return servAdicionalService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ServAdicional> obtenerPorNombre(@PathVariable String nombre) {
        return servAdicionalService.findByNombre(nombre)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServAdicional> crear(@RequestBody ServAdicional servicio) {
        return ResponseEntity.ok(servAdicionalService.save(servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServAdicional> actualizar(@PathVariable Long id, @RequestBody ServAdicional datos) {
        return servAdicionalService.findById(id)
                .map(servicioAd -> {
                    servicioAd.setNombre(datos.getNombre());
                    servicioAd.setDescripcion(datos.getDescripcion());
                   return ResponseEntity.ok(servAdicionalService.save(servicioAd));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servAdicionalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

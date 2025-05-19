package com.dream_team.proyecto_final_progra3.controller;

import com.dream_team.proyecto_final_progra3.entity.Credenciales;
import com.dream_team.proyecto_final_progra3.service.CredencialesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/credenciales")
public class CredencialesController {
    @Autowired
    private CredencialesService credencialesService;

    @GetMapping("/{id}")
    public ResponseEntity<Credenciales> getCredencialesById(@PathVariable Long id) {
        Optional<Credenciales> credenciales = credencialesService.findById(id);
        return credenciales.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Credenciales createCredenciales(@RequestBody Credenciales credenciales) {
        return credencialesService.save(credenciales);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Credenciales> updateCredenciales(@PathVariable Long id, @RequestBody Credenciales credencialesDetails) {
        Optional<Credenciales> credenciales = credencialesService.findById(id);
        if (credenciales.isPresent()) {
            Credenciales updatedCredenciales = credenciales.get();
            // Actualizar campos aquí
            return ResponseEntity.ok(credencialesService.save(updatedCredenciales));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCredenciales(@PathVariable Long id) {
        credencialesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{nombreUsuario}")
    public ResponseEntity<Credenciales> getByNombreUsuario(@PathVariable String nombreUsuario) {
        Credenciales credenciales = credencialesService.findByNombreUsuario(nombreUsuario);
        if (credenciales != null) {
            return ResponseEntity.ok(credenciales);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
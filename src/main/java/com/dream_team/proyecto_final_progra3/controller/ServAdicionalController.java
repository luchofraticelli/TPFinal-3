package com.dream_team.proyecto_final_progra3.controller;

import com.dream_team.proyecto_final_progra3.dto.ServAdicionalDTO;
import com.dream_team.proyecto_final_progra3.entity.ServAdicional;
import com.dream_team.proyecto_final_progra3.entity.enums.ServAdicionalEnum;
import com.dream_team.proyecto_final_progra3.service.ServAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/servicios-adicionales")
public class ServAdicionalController {

    private final ServAdicionalService servAdicionalService;

    @Autowired
    public ServAdicionalController(ServAdicionalService servAdicionalService) {
        this.servAdicionalService = servAdicionalService;
    }

    // 1) LISTAR TODOS → devolver List<ServAdicionalDTO>
    @GetMapping
    public ResponseEntity<List<ServAdicionalDTO>> listar() {
        List<ServAdicional> entidades = servAdicionalService.findAll();

        List<ServAdicionalDTO> dtos = entidades.stream()
                .map(entidad -> new ServAdicionalDTO(
                        entidad.getId(),
                        entidad.getNombre().name(),   // convierto el enum a String
                        entidad.getDescripcion()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    // 2) OBTENER POR ID → devolver ServAdicionalDTO
    @GetMapping("/{id}")
    public ResponseEntity<ServAdicionalDTO> obtenerPorId(@PathVariable Long id) {
        return servAdicionalService.findById(id)
                .map(entidad -> {
                    ServAdicionalDTO dto = new ServAdicionalDTO(
                            entidad.getId(),
                            entidad.getNombre().name(),
                            entidad.getDescripcion()
                    );
                    return ResponseEntity.ok(dto);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3) OBTENER POR NOMBRE → devolver ServAdicionalDTO
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ServAdicionalDTO> obtenerPorNombre(@PathVariable String nombre) {
        // Primero intento convertir el nombre (String) a ServAdicionalEnum
        ServAdicionalEnum enumBuscado;
        try {
            enumBuscado = ServAdicionalEnum.valueOf(nombre.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        return servAdicionalService.findByNombre(String.valueOf(enumBuscado))
                .map(entidad -> {
                    ServAdicionalDTO dto = new ServAdicionalDTO(
                            entidad.getId(),
                            entidad.getNombre().name(),
                            entidad.getDescripcion()
                    );
                    return ResponseEntity.ok(dto);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4) CREAR NUEVO → recibir ServAdicionalDTO y devolver ServAdicionalDTO
    @PostMapping
    public ResponseEntity<ServAdicionalDTO> crear(@RequestBody ServAdicionalDTO dtoRequest) {
        // Validar que nombre no venga nulo
        if (dtoRequest.getNombre() == null) {
            return ResponseEntity.badRequest().build();
        }

        // 4.1 Convertir String → ServAdicionalEnum
        ServAdicionalEnum enumNombre;
        try {
            enumNombre = ServAdicionalEnum.valueOf(dtoRequest.getNombre().toUpperCase());
        } catch (IllegalArgumentException e) {
            // El valor de nombre no corresponde a ningún enum
            return ResponseEntity.badRequest().build();
        }

        // 4.2 Construir la entidad a partir del DTO
        ServAdicional entidad = new ServAdicional();
        entidad.setNombre(enumNombre);
        entidad.setDescripcion(dtoRequest.getDescripcion());

        // 4.3 Guardar entidad
        ServAdicional guardada = servAdicionalService.save(entidad);

        // 4.4 Convertir la entidad guardada a DTO de respuesta
        ServAdicionalDTO dtoResponse = new ServAdicionalDTO(
                guardada.getId(),
                guardada.getNombre().name(),
                guardada.getDescripcion()
        );
        return ResponseEntity.ok(dtoResponse);
    }

    // 5) ACTUALIZAR EXISTENTE → recibir ServAdicionalDTO, devolver ServAdicionalDTO actualizado
    @PutMapping("/{id}")
    public ResponseEntity<ServAdicionalDTO> actualizar(
            @PathVariable Long id,
            @RequestBody ServAdicionalDTO dtoRequest) {

        return servAdicionalService.findById(id)
                .map(entidadExistente -> {
                    // Si en el DTO viene nombre, lo convierto a enum y actualizo
                    if (dtoRequest.getNombre() != null) {
                        try {
                            ServAdicionalEnum enumNombre = ServAdicionalEnum.valueOf(dtoRequest.getNombre().toUpperCase());
                            entidadExistente.setNombre(enumNombre);
                        } catch (IllegalArgumentException e) {
                            // Nombre inválido
                            return ResponseEntity.badRequest().<ServAdicionalDTO>build();
                        }
                    }
                    // Actualizo el costo
                    entidadExistente.setDescripcion(dtoRequest.getDescripcion());

                    // Guardo cambios
                    ServAdicional actualizada = servAdicionalService.save(entidadExistente);

                    // Convierto a DTO de respuesta
                    ServAdicionalDTO dtoResponse = new ServAdicionalDTO(
                            actualizada.getId(),
                            actualizada.getNombre().name(),
                            actualizada.getDescripcion()
                    );
                    return ResponseEntity.ok(dtoResponse);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 6) ELIMINAR POR ID → no devolvemos entidad ni DTO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servAdicionalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
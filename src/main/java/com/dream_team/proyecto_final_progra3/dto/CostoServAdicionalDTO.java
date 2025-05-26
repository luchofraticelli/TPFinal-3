package com.dream_team.proyecto_final_progra3.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostoServAdicionalDTO {
    private Long id;
    private String nombreServicioAdicional;
    private Integer cantidad;
    private LocalDate fechaConsumo;
    private Double precioUnitario;
    private Double precioTotal;
}

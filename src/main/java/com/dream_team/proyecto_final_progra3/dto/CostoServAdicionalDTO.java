package com.dream_team.proyecto_final_progra3.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CostoServAdicionalDTO {
    private Long id;
    private ServicioDTO nombreServicioAdicional;
    private Double precioUnitario;


}

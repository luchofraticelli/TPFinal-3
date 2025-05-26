package com.dream_team.proyecto_final_progra3.dto;

import com.dream_team.proyecto_final_progra3.entity.enums.ServAdicionalEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoServAdicionalDTO {
    private Long id;
    private String nombreServicioAdicional;
    private Integer cantidad;
    private LocalDate fechaConsumo;
    private Double precioUnitario;     // el precio de ese servicio en la fecha
    private Double precioTotal;


}

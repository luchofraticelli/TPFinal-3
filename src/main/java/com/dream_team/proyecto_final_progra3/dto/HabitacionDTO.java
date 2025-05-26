package com.dream_team.proyecto_final_progra3.dto;

import com.dream_team.proyecto_final_progra3.entity.enums.TipoHabitacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitacionDTO {
    private Long id;
    private String numeroHabitacion;
    private Integer capacidad;
    private String tipoHabitacion;
    private String estado;
    private Map<String, Boolean> servicios;
}

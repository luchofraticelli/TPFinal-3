package com.dream_team.proyecto_final_progra3.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDTO {

      private Long id;
    private String nombre;
    private Double costo;
}

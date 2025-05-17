package com.dream_team.proyecto_final_progra3.entity;

import com.dream_team.proyecto_final_progra3.entity.enums.TipoHabitacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "costos_habitacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CostoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private TipoHabitacion tipoHabitacion;

    @Column(nullable = false)
    private Double costo;
}
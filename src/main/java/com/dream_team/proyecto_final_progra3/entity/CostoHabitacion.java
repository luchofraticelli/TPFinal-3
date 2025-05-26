package com.dream_team.proyecto_final_progra3.entity;

import com.dream_team.proyecto_final_progra3.entity.enums.TipoHabitacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "costos_habitacion")
@Getter @Setter
public class CostoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private TipoHabitacion tipoHabitacion;

    @Column(nullable = false)
    private Double costo;

    public Long getId() {
        return id;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public Double getCosto() {
        return costo;
    }
}
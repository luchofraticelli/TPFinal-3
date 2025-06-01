package com.dream_team.proyecto_final_progra3.entity;

import com.dream_team.proyecto_final_progra3.entity.enums.ServicioEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servicios")
@Getter
@Setter
public class CostoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ServicioEnum nombre;

    private Double costo;


}
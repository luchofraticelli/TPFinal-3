package com.dream_team.proyecto_final_progra3.entity;

import com.dream_team.proyecto_final_progra3.entity.enums.EstadoReserva;
import com.dream_team.proyecto_final_progra3.entity.enums.ServAdicionalEnum;
import com.dream_team.proyecto_final_progra3.entity.enums.ServicioEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "reservas")
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pasajero_id", nullable = false)
    private Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "habitacion_id", nullable = false)
    private Habitacion habitacion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @ElementCollection
    @CollectionTable(
            name = "reserva_serv_adicional_cantidad",
            joinColumns = @JoinColumn(name = "reserva_id")
    )
    @MapKeyJoinColumn(name = "costo_serv_adicional_id")
    @Column(name = "cantidad")
    private Map<CostoServAdicional, Integer> serviciosAdicionalesConCantidad = new HashMap<>();

    private String observaciones;


}
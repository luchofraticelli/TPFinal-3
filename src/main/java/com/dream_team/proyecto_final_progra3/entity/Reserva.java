package com.dream_team.proyecto_final_progra3.entity;

import com.dream_team.proyecto_final_progra3.entity.enums.EstadoReserva;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsumoServAdicional> consumosServiciosAdicionales = new ArrayList<>();

    private String observaciones;

    public Long getId() {
        return id;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public List<ConsumoServAdicional> getConsumosServiciosAdicionales() {
        return consumosServiciosAdicionales;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
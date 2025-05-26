package com.dream_team.proyecto_final_progra3.entity;

import com.dream_team.proyecto_final_progra3.entity.enums.EstadoHabitacion;
import com.dream_team.proyecto_final_progra3.entity.enums.ServicioEnum;
import com.dream_team.proyecto_final_progra3.entity.enums.TipoHabitacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "habitaciones")
@Getter
@Setter
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_habitacion", unique = true, nullable = false)
    private String numeroHabitacion;

    private Integer capacidad;

    @Enumerated(EnumType.STRING)
    private TipoHabitacion tipoHabitacion;

    @Enumerated(EnumType.STRING)
    private EstadoHabitacion estado;

    @ElementCollection
    @CollectionTable(name = "habitacion_servicios", joinColumns = @JoinColumn(name = "habitacion_id"))
    @MapKeyColumn(name = "servicio")
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "disponible")
    private Map<ServicioEnum, Boolean> servicios = new EnumMap<>(ServicioEnum.class);

    @OneToMany(mappedBy = "habitacion")
    private List<Reserva> reservas;

    public Long getId() {
        return id;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public Map<ServicioEnum, Boolean> getServicios() {
        return servicios;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}
package com.dream_team.proyecto_final_progra3.entity;

import com.dream_team.proyecto_final_progra3.entity.enums.EstadoEmpleado;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "horas_trabajadas")
    private Integer horasTrabajadas;

    @Enumerated(EnumType.STRING)
    private EstadoEmpleado estado;

    @OneToMany(mappedBy = "empleado")
    private List<Reserva> reservas;
}
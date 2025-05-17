package com.dream_team.proyecto_final_progra3.entity;

import com.dream_team.proyecto_final_progra3.entity.enums.EstadoPasajero;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pasajeros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private EstadoPasajero estado;

    @OneToMany(mappedBy = "pasajero")
    private List<Reserva> reservas;
}
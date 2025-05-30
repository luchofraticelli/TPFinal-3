 package com.dream_team.proyecto_final_progra3.repository;

import com.dream_team.proyecto_final_progra3.entity.Reserva;
import com.dream_team.proyecto_final_progra3.entity.enums.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByFechaInicioBetween(LocalDate inicio, LocalDate fin);
    List<Reserva> findByPasajeroId(Long pasajeroId);
    List<Reserva> findByHabitacionId(Long habitacionId);
    List<Reserva> findByEstado(EstadoReserva estado);
}
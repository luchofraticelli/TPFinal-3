package com.dream_team.proyecto_final_progra3.repository;

import com.dream_team.proyecto_final_progra3.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByEstado(String estado);
    @Query("SELECT h FROM Habitacion h WHERE h.id NOT IN (" +
            "SELECT r.habitacion.id FROM Reserva r WHERE " +
            "(:fechaInicio <= r.fechaFin AND :fechaFin >= r.fechaInicio))")
    List<Habitacion> encontrarDisponibilidad(@Param("fechaInicio") LocalDate fechaInicio,
                                             @Param("fechaFin") LocalDate fechaFin);
    List<Habitacion> findByTipoHabitacion(String tipo);
    Habitacion findByNumeroHabitacion(String numero);
}
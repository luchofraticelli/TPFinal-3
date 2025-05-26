package com.dream_team.proyecto_final_progra3.repository;

import com.dream_team.proyecto_final_progra3.entity.Habitacion;
import com.dream_team.proyecto_final_progra3.entity.enums.EstadoHabitacion;
import com.dream_team.proyecto_final_progra3.entity.enums.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByEstado(EstadoHabitacion estado);
    List<Habitacion> findByTipoHabitacion(TipoHabitacion tipo);
    Habitacion findByNumeroHabitacion(String numero);
}
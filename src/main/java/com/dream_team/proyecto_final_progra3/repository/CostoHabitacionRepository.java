package com.dream_team.proyecto_final_progra3.repository;

import com.dream_team.proyecto_final_progra3.entity.CostoHabitacion;
import com.dream_team.proyecto_final_progra3.entity.enums.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostoHabitacionRepository extends JpaRepository<CostoHabitacion, Long> {
    Optional<CostoHabitacion> findByTipoHabitacion(TipoHabitacion tipoHabitacion);
}
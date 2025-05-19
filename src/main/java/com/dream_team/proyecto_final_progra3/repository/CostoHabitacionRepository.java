package com.dream_team.proyecto_final_progra3.repository;

import com.dream_team.proyecto_final_progra3.entity.CostoHabitacion;
import com.dream_team.proyecto_final_progra3.entity.enums.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoHabitacionRepository extends JpaRepository<CostoHabitacion, Long> {
    CostoHabitacion findByTipoHabitacion(TipoHabitacion tipo);
}
package com.dream_team.proyecto_final_progra3.repository;

import com.dream_team.proyecto_final_progra3.entity.CostoServicio;
import com.dream_team.proyecto_final_progra3.entity.enums.ServicioEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostoServicioRepository extends JpaRepository<CostoServicio, Long> {
    Optional<CostoServicio> findByNombre(ServicioEnum nombre);
}
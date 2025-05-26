package com.dream_team.proyecto_final_progra3.repository;

import com.dream_team.proyecto_final_progra3.entity.CostoServAdicional;
import com.dream_team.proyecto_final_progra3.entity.ServAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CostoServAdicionalRepository extends JpaRepository <CostoServAdicional, Long>{
    Optional <CostoServAdicional>  findByServAdicionalAndFechaDesdeLessThanEqualAndFechaHastaGreaterThanEqual(
            ServAdicional servAdicional, LocalDate fechaDesde, LocalDate fechaHasta
    );
}

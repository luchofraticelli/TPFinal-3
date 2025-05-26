package com.dream_team.proyecto_final_progra3.repository;

import com.dream_team.proyecto_final_progra3.entity.ConsumoServAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ConsumoServAdicionalRepository extends JpaRepository <ConsumoServAdicional, Long> {
    List<ConsumoServAdicional> FindByReservaId(Long reservaId);
}

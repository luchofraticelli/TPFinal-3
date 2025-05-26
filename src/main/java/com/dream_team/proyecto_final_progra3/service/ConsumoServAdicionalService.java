package com.dream_team.proyecto_final_progra3.service;

import com.dream_team.proyecto_final_progra3.entity.ConsumoServAdicional;
import com.dream_team.proyecto_final_progra3.repository.ConsumoServAdicionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumoServAdicionalService {

    @Autowired
    ConsumoServAdicionalRepository consumoServAdicionalRepository;


    public List<ConsumoServAdicional> findByReservaId(Long reservaId) {
        return consumoServAdicionalRepository.FindByReservaId(reservaId);
    }

    public ConsumoServAdicional save(ConsumoServAdicional consumo) {
        return consumoServAdicionalRepository.save(consumo);
    }

    public Optional<ConsumoServAdicional> findById(Long id) {
        return consumoServAdicionalRepository.findById(id);
    }

    public void deleteById(Long id) {
        consumoServAdicionalRepository.deleteById(id);
    }
}

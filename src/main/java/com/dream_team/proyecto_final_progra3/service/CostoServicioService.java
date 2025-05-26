package com.dream_team.proyecto_final_progra3.service;

import com.dream_team.proyecto_final_progra3.entity.CostoServicio;
import com.dream_team.proyecto_final_progra3.repository.CostoServicioRepository;
import com.dream_team.proyecto_final_progra3.entity.enums.ServicioEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostoServicioService {
    private final CostoServicioRepository costoServicioRepository;

    @Autowired
    public CostoServicioService(CostoServicioRepository servicioRepository) {
        this.costoServicioRepository = servicioRepository;
    }

    public List<CostoServicio> findAll() {
        return costoServicioRepository.findAll();
    }

    public Optional<CostoServicio> findById(Long id) {
        return costoServicioRepository.findById(id);
    }

    public CostoServicio save(CostoServicio servicio) {
        return costoServicioRepository.save(servicio);
    }

    public void deleteById(Long id) {
        costoServicioRepository.deleteById(id);
    }

    public Optional<CostoServicio> findByNombre(String nombre) {
        try {
            ServicioEnum servicioEnum = ServicioEnum.valueOf(nombre.toUpperCase());
            return costoServicioRepository.findByNombre(servicioEnum);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
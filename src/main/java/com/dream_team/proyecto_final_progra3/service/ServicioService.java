package com.dream_team.proyecto_final_progra3.service;

import com.dream_team.proyecto_final_progra3.entity.Servicio;
import com.dream_team.proyecto_final_progra3.repository.ServicioRepository;
import com.dream_team.proyecto_final_progra3.entity.enums.ServicioEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {
    private final ServicioRepository servicioRepository;

    @Autowired
    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    public Optional<Servicio> findById(Long id) {
        return servicioRepository.findById(id);
    }

    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public void deleteById(Long id) {
        servicioRepository.deleteById(id);
    }

    public Servicio findByNombre(String nombre) {
        ServicioEnum nombreEnum = ServicioEnum.valueOf(nombre.toUpperCase());
        return servicioRepository.findByNombre(nombreEnum);
    }
}
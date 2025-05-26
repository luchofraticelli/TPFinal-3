package com.dream_team.proyecto_final_progra3.service;

import com.dream_team.proyecto_final_progra3.entity.CostoHabitacion;
import com.dream_team.proyecto_final_progra3.repository.CostoHabitacionRepository;
import com.dream_team.proyecto_final_progra3.entity.enums.TipoHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostoHabitacionService {
    private final CostoHabitacionRepository costoHabitacionRepository;

    @Autowired
    public CostoHabitacionService(CostoHabitacionRepository costoHabitacionRepository) {
        this.costoHabitacionRepository = costoHabitacionRepository;
    }

    public List<CostoHabitacion> findAll() {
        return costoHabitacionRepository.findAll();
    }

    public Optional<CostoHabitacion> findById(Long id) {
        return costoHabitacionRepository.findById(id);
    }

    public CostoHabitacion save(CostoHabitacion costoHabitacion) {
        return costoHabitacionRepository.save(costoHabitacion);
    }

    public void deleteById(Long id) {
        costoHabitacionRepository.deleteById(id);
    }

    public Optional<CostoHabitacion> findByTipoHabitacion(TipoHabitacion tipo) {
        return costoHabitacionRepository.findByTipoHabitacion(tipo);
    }
}
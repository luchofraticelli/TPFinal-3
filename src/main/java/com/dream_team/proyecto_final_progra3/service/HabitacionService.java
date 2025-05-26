package com.dream_team.proyecto_final_progra3.service;

import com.dream_team.proyecto_final_progra3.entity.Habitacion;
import com.dream_team.proyecto_final_progra3.entity.enums.EstadoHabitacion;
import com.dream_team.proyecto_final_progra3.entity.enums.TipoHabitacion;
import com.dream_team.proyecto_final_progra3.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {
    private final HabitacionRepository habitacionRepository;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public List<Habitacion> findAll() {
        return habitacionRepository.findAll();
    }

    public Optional<Habitacion> findById(Long id) {
        return habitacionRepository.findById(id);
    }

    public Habitacion save(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public void deleteById(Long id) {
        habitacionRepository.deleteById(id);
    }

    public List<Habitacion> findByEstado(EstadoHabitacion estado) {
        return habitacionRepository.findByEstado(estado);
    }

    public List<Habitacion> findByTipoHabitacion(TipoHabitacion tipo) {
        return habitacionRepository.findByTipoHabitacion(tipo);
    }

    public Habitacion findByNumeroHabitacion(String numero) {
        return habitacionRepository.findByNumeroHabitacion(numero);
    }
}
package com.dream_team.proyecto_final_progra3.service;

import com.dream_team.proyecto_final_progra3.dto.*;
import com.dream_team.proyecto_final_progra3.entity.*;
import com.dream_team.proyecto_final_progra3.entity.enums.ServicioEnum;
import com.dream_team.proyecto_final_progra3.repository.CostoHabitacionRepository;
import com.dream_team.proyecto_final_progra3.repository.CostoServicioRepository;
import com.dream_team.proyecto_final_progra3.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Autowired
    private CostoServAdicionalService costoServAdicionalService;
    @Autowired
    private HabitacionService habitacionService;
    @Autowired
    private CostoHabitacionService costoHabitacionService;
    @Autowired
    CostoServicioRepository costoServicioRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    public List<Reserva> findByFechaInicioBetween(LocalDate inicio, LocalDate fin) {
        return reservaRepository.findByFechaInicioBetween(inicio, fin);
    }

    public List<Reserva> findByPasajeroId(Long pasajeroId) {
        return reservaRepository.findByPasajeroId(pasajeroId);
    }

    public List<Reserva> findByHabitacionId(Long habitacionId) {
        return reservaRepository.findByHabitacionId(habitacionId);
    }


    public List<Reserva> findByEstado(String estado) {
        return reservaRepository.findByEstado(estado);
    }



}


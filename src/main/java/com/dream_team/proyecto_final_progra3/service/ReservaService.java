package com.dream_team.proyecto_final_progra3.service;

import com.dream_team.proyecto_final_progra3.entity.Empleado;
import com.dream_team.proyecto_final_progra3.entity.Habitacion;
import com.dream_team.proyecto_final_progra3.entity.Pasajero;
import com.dream_team.proyecto_final_progra3.entity.Reserva;
import com.dream_team.proyecto_final_progra3.entity.enums.EstadoReserva;
import com.dream_team.proyecto_final_progra3.repository.EmpleadoRepository;
import com.dream_team.proyecto_final_progra3.repository.HabitacionRepository;
import com.dream_team.proyecto_final_progra3.repository.PasajeroRepository;
import com.dream_team.proyecto_final_progra3.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;


@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    private final EmpleadoRepository empleadoRepository;

    private final PasajeroRepository pasajeroRepository;

    private final HabitacionRepository habitacionRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, EmpleadoRepository empleadoRepository, PasajeroRepository pasajeroRepository, HabitacionRepository habitacionRepository) {
        this.reservaRepository = reservaRepository;
        this.empleadoRepository = empleadoRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.habitacionRepository = habitacionRepository;
    }


    public void AsignarEmpleadoReserva(long reservaId, long empleadoId) {
        Empleado empleado=empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new RuntimeException("empleado no encontrado"));

        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
            reserva.setEmpleado(empleado);
        reservaRepository.save(reserva);
    }


    public void asignarPasajeroAReserva(Long reservaId, Long pasajeroId) {
        Pasajero pasajero = pasajeroRepository.findById(pasajeroId)
                .orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));

        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reserva.setPasajero(pasajero);
        reservaRepository.save(reserva);
    }

    public void crearReserva(Reserva reserva){
            List<Habitacion> habitacionesDisponibles = habitacionRepository.encontrarDisponibilidad(reserva.getFechaInicio(), reserva.getFechaFin());
            //comprobamos si la hab esta disponible
            boolean habitacionDisponible = habitacionesDisponibles.stream()
                    .anyMatch(habitacion -> habitacion.getId().equals(reserva.getHabitacion().getId()));
            if (!habitacionDisponible) {
                throw new IllegalArgumentException("La habitación con ID " + reserva.getHabitacion().getId() + " no está disponible en las fechas seleccionadas.");

            }
        reservaRepository.save(reserva);
        }




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

    public List<Reserva> findByEstado(EstadoReserva estado) {
        return reservaRepository.findByEstado(estado);
    }
}
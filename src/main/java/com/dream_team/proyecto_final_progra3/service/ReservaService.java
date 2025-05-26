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
    private ConsumoServAdicionalService consumoServAdicionalService;
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


    public FacturacionDTO calcularFactura(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        Habitacion habitacion = reserva.getHabitacion();

        // 1. Precio base de la habitación
        Double precioBase = costoHabitacionService
                .findByTipoHabitacion(habitacion.getTipoHabitacion())
                .orElseThrow(() -> new RuntimeException("No hay precio base para este tipo de habitación"))
                .getCosto();

        // 2. Servicios fijos activos de la habitación (consultando cada precio en BD)
        List<ServicioDTO> serviciosHabitacion = habitacion.getServicios().entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(entry -> {
                    ServicioEnum servicioEnum = entry.getKey();
                    Double costo = costoServicioRepository.findByNombre(servicioEnum)
                            .map(CostoServicio::getCosto)
                            .orElseThrow(() -> new RuntimeException("No hay precio cargado para el servicio fijo: " + servicioEnum.name()));
                    return new ServicioDTO(null, servicioEnum.name(), costo);
                })
                .toList();

        Double totalServiciosHabitacion = serviciosHabitacion.stream()
                .mapToDouble(ServicioDTO::getCosto)
                .sum();

        // 3. Consumos de servicios adicionales y sus precios históricos
        List<ConsumoServAdicional> consumos = consumoServAdicionalService.findByReservaId(reservaId);

        List<ConsumoServAdicionalDTO> serviciosAdicionales = consumos.stream()
                .map(consumo -> {
                    var adicional = consumo.getServAdicional();
                    var fecha = consumo.getFechaConsumo();
                    var cantidad = consumo.getCantidad() != null ? consumo.getCantidad() : 1;
                    var costo = costoServAdicionalService.findVigente(adicional, fecha)
                            .orElseThrow(() -> new RuntimeException("No hay precio vigente para " +
                                    (adicional.getNombre() instanceof Enum ? adicional.getNombre().name() : adicional.getNombre()) +
                                    " en la fecha " + fecha));
                    Double precioUnitario = costo.getPrecio();
                    Double precioTotal = precioUnitario * cantidad;
                    String nombre = (adicional.getNombre() instanceof Enum)
                            ? ((Enum<?>) adicional.getNombre()).name()
                            : String.valueOf(adicional.getNombre());
                    return new ConsumoServAdicionalDTO(
                            adicional.getId(),
                            nombre,
                            cantidad,
                            fecha,
                            precioUnitario,
                            precioTotal
                    );
                })
                .toList();

        Double totalServiciosAdicionales = serviciosAdicionales.stream()
                .mapToDouble(ConsumoServAdicionalDTO::getPrecioTotal)
                .sum();

        // 4. Cálculo de días de estadía (mínimo 1 día)
        long dias = ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin());
        if (dias <= 0) dias = 1;

        // 5. Subtotal y total
        Double subtotal = precioBase + totalServiciosHabitacion + totalServiciosAdicionales;
        Double total = subtotal * dias;

        // 6. Retornar el DTO final
        return new FacturacionDTO(
                reserva.getId(),
                habitacion.getNumeroHabitacion(),
                habitacion.getTipoHabitacion().name(),
                (int) dias,
                precioBase,
                serviciosHabitacion,
                serviciosAdicionales,
                subtotal,
                total
        );


    }
}


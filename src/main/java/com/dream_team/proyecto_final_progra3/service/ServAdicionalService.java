package com.dream_team.proyecto_final_progra3.service;

import com.dream_team.proyecto_final_progra3.entity.ServAdicional;
import com.dream_team.proyecto_final_progra3.repository.ServAdicionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServAdicionalService {


    private final ServAdicionalRepository servAdicionalRepository;

    @Autowired
    public ServAdicionalService(ServAdicionalRepository servAdicionalRepository) {
        this.servAdicionalRepository = servAdicionalRepository;
    }

    public List<ServAdicional> findAll() {
        return servAdicionalRepository.findAll();
    }

    public Optional<ServAdicional> findById(Long id) {
        return servAdicionalRepository.findById(id);
    }

    public ServAdicional save(ServAdicional servicioAdicional) {
        return servAdicionalRepository.save(servicioAdicional);
    }

    public void deleteById(Long id) {
        servAdicionalRepository.deleteById(id);
    }

    public Optional<ServAdicional> findByNombre(String nombre) {
        return servAdicionalRepository.findByNombreIgnoreCase(nombre);
    }



}

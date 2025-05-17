package com.dream_team.proyecto_final_progra3.service;

import com.dream_team.proyecto_final_progra3.entity.Credenciales;
import com.dream_team.proyecto_final_progra3.repository.CredencialesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CredencialesService {
    private final CredencialesRepository credencialesRepository;

    @Autowired
    public CredencialesService(CredencialesRepository credencialesRepository) {
        this.credencialesRepository = credencialesRepository;
    }

    public Credenciales save(Credenciales credenciales) {
        return credencialesRepository.save(credenciales);
    }

    public Optional<Credenciales> findById(Long id) {
        return credencialesRepository.findById(id);
    }

    public Credenciales findByNombreUsuario(String nombreUsuario) {
        return credencialesRepository.findByNombreUsuario(nombreUsuario);
    }

    public void deleteById(Long id) {
        credencialesRepository.deleteById(id);
    }
}

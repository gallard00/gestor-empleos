package com.example.empleos.Services;

import com.example.empleos.Dtos.EquipoRequest;
import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Models.Equipo;

import java.util.List;
import java.util.Optional;

public interface EquipoService {
    EquipoResponse createEquipo(EquipoRequest request);
    List<EquipoResponse> getAllEquipos();
    EquipoResponse getEquipoById(Long id);
    EquipoResponse updateEquipo(Long id, EquipoRequest request);
    void deleteEquipo(Long id);
    Optional<Equipo> findEquipoById(Long id);
}

package com.example.empleos.Services;

import com.example.empleos.Dtos.EquipoRequest;
import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Models.Equipo;

import java.util.List;

public interface EquipoService {
    EquipoResponse createEquipo(EquipoRequest request);
    EquipoResponse getEquipoById(Long id);
    Equipo getEquipoEntityById(Long id);
    List<EquipoResponse> getAllEquipos();
    EquipoResponse updateEquipo(Long id, EquipoRequest request);
    void deleteEquipo(Long id);
}

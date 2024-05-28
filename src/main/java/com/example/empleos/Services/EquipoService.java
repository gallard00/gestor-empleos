package com.example.empleos.Services;

import com.example.empleos.Dtos.EquipoRequest;
import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Models.Equipo;

import java.util.List;

public interface EquipoService {
    EquipoResponse getEquipoById(Long id);
    List<EquipoResponse> getAllEquipos();
    EquipoResponse createEquipo(EquipoRequest equipoRequest);
    EquipoResponse updateEquipo(Long id, EquipoRequest equipoRequest);
    void deleteEquipo(Long id);
}

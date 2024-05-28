package com.example.empleos.Services;

import com.example.empleos.Dtos.PartidoRequest;
import com.example.empleos.Dtos.PartidoResponse;

import java.util.List;

public interface PartidoService {
    List<PartidoResponse> getAllPartidos();
    PartidoResponse getPartidoById(Long id);
    PartidoResponse createPartido(PartidoRequest partidoRequest);
    PartidoResponse updatePartido(Long id, PartidoRequest partidoRequest);
    void deletePartido(Long id);
}

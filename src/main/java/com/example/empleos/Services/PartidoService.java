package com.example.empleos.Services;

import com.example.empleos.Dtos.PartidoRequest;
import com.example.empleos.Dtos.PartidoResponse;
import com.example.empleos.Models.Jugador;
import com.example.empleos.Models.Partido;

import java.util.List;

public interface PartidoService {
    PartidoResponse createPartido(PartidoRequest request);
    PartidoResponse getPartidoById(Long id);
    Partido getPartidoEntityById(Long id);
    List<PartidoResponse> getAllPartidos();
    PartidoResponse updatePartido(Long id, PartidoRequest request);
    void deletePartido(Long id);
}

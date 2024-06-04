package com.example.empleos.Services;

import com.example.empleos.Dtos.PartidoRequest;
import com.example.empleos.Dtos.PartidoResponse;
import com.example.empleos.Models.Jugador;
import com.example.empleos.Models.Partido;

import java.util.List;
import java.util.Optional;

public interface PartidoService {
    PartidoResponse createPartido(PartidoRequest request);
    List<PartidoResponse> getAllPartidos();
    PartidoResponse getPartidoById(Long id);
    PartidoResponse updatePartido(Long id, PartidoRequest request);
    void deletePartido(Long id);
    Optional<Partido> findPartidoById(Long id);
}

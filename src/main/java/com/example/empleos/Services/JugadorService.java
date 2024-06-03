package com.example.empleos.Services;

import com.example.empleos.Dtos.JugadorRequest;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Jugador;

import java.util.List;

public interface JugadorService {
    JugadorResponse createJugador(JugadorRequest request);
    JugadorResponse getJugadorById(Long id);
    Jugador getJugadorEntityById(Long id);
    List<JugadorResponse> getAllJugadores();
    JugadorResponse updateJugador(Long id, JugadorRequest request);
    void deleteJugador(Long id);
}

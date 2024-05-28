package com.example.empleos.Services;

import com.example.empleos.Dtos.JugadorRequest;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Models.Jugador;

import java.util.List;

public interface JugadorService {
    List<JugadorResponse> getAllJugadores();
    JugadorResponse getJugadorById(Long id);
    JugadorResponse createJugador(JugadorRequest jugadorRequest);
    JugadorResponse updateJugador(Long id, JugadorRequest jugadorRequest);
    void deleteJugador(Long id);
}

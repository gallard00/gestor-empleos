package com.example.empleos.Services;

import com.example.empleos.Dtos.JugadorRequest;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Jugador;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface JugadorService {
    JugadorResponse createJugador(JugadorRequest request);
    List<JugadorResponse> getAllJugadores();
    JugadorResponse getJugadorById(Long id);
    JugadorResponse updateJugador(Long id, JugadorRequest request);
    void deleteJugador(Long id);
    Optional<Jugador> findJugadorById(Long id);
}

package com.example.empleos.Mappers;

import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Dtos.JugadorRequest;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Jugador;
import com.example.empleos.Models.Liga;
import com.example.empleos.Services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class JugadorMapper {

    @Autowired
    private EquipoService equipoService;

    public Jugador jugadorRequestToJugador(JugadorRequest request) {
        Equipo equipo = equipoService.findEquipoById(request.getEquipoId())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        return Jugador.builder()
                .nombre(request.getNombre())
                .equipo(equipo)
                .build();
    }

    public JugadorResponse jugadorToJugadorResponse(Jugador jugador) {
        return JugadorResponse.builder()
                .id(jugador.getId())
                .nombre(jugador.getNombre())
                .equipo(EquipoResponse.builder()
                        .id(jugador.getEquipo().getId())
                        .nombre(jugador.getEquipo().getNombre())
                        .build())
                .build();
    }
}

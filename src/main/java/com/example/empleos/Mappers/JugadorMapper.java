package com.example.empleos.Mappers;

import com.example.empleos.Dtos.JugadorRequest;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Jugador;
import com.example.empleos.Models.Liga;
import com.example.empleos.Services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;

public class JugadorMapper {

    @Autowired
    private EquipoService equipoService;

    public Jugador jugadorRequestToJugador (JugadorRequest jugadorRequest) {
        Jugador jugador = new Jugador();

        jugador.setNombre(jugadorRequest.getNombre());
        jugador.setApellido(jugadorRequest.getApellido());
        jugador.setPosicion(jugadorRequest.getPosicion());

        Equipo equipo = equipoService.getEquipoById(jugadorRequest.getEquipoId());

        jugador.setEquipo(equipo);

        return jugador;

    }

    public JugadorResponse jugadorToJugadorResponse (Jugador jugador) {
        JugadorResponse jugadorResponse = new JugadorResponse();

        jugadorResponse.setId(jugador.getId());
        jugadorResponse.setNombre(jugador.getNombre());
        jugadorResponse.setApellido(jugador.getApellido());
        jugadorResponse.setPosicion(jugador.getPosicion());
        jugadorResponse.setEquipoId(jugador.getEquipo().getId());

        return jugadorResponse;
    }
}

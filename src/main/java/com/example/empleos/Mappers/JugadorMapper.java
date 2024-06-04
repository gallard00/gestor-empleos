package com.example.empleos.Mappers;

import com.example.empleos.Dtos.JugadorRequest;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Jugador;
import com.example.empleos.Models.Liga;
import com.example.empleos.Services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JugadorMapper {

    @Autowired
    private EquipoMapper equipoMapper;

    @Autowired
    private EquipoService equipoService;

    public Jugador toModel (JugadorRequest request) {
        Jugador jugador = new Jugador();
        jugador.setNombre(request.getNombre());
        jugador.setApellido(request.getApellido());
        jugador.setPosicion(request.getPosicion());
        if (request.getEquipoId() != null) {
            Equipo equipo = equipoService.getEquipoEntityById(request.getEquipoId());
            jugador.setEquipo(equipo);
        }
        return jugador;

    }

    public JugadorResponse toResponse (Jugador jugador) {
        JugadorResponse response = new JugadorResponse();
        response.setId(jugador.getId());
        response.setNombre(jugador.getNombre());
        response.setApellido(jugador.getApellido());
        response.setPosicion(jugador.getPosicion());

        if (jugador.getEquipo() != null) {
            response.setEquipo(equipoMapper.toResponse(jugador.getEquipo()));
        }

        return response;
    }
}

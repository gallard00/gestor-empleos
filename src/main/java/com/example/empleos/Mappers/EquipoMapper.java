package com.example.empleos.Mappers;

import com.example.empleos.Dtos.EquipoRequest;
import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Dtos.LigaResponse;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Jugador;
import com.example.empleos.Models.Liga;
import com.example.empleos.Services.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EquipoMapper {

    @Autowired
    private LigaService ligaService;

    @Autowired
    private JugadorMapper jugadorMapper;

    public Equipo equipoRequestToEquipo(EquipoRequest request) {
        Liga liga = ligaService.findLigaById(request.getLigaId())
                .orElseThrow(() -> new RuntimeException("Liga no encontrada"));

        return Equipo.builder()
                .nombre(request.getNombre())
                .liga(liga)
                .build();
    }

    public EquipoResponse equipoToEquipoResponse(Equipo equipo) {
        return EquipoResponse.builder()
                .id(equipo.getId())
                .nombre(equipo.getNombre())
                .liga(ligaService.getLigaById(equipo.getLiga().getId()))
                .jugadores(equipo.getJugadores().stream()
                        .map(jugadorMapper::jugadorToJugadorResponse)
                        .collect(Collectors.toList()))
                .build();
    }

}

package com.example.empleos.Mappers;

import com.example.empleos.Dtos.EquipoRequest;
import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Dtos.LigaResponse;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Liga;
import com.example.empleos.Services.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EquipoMapper {

    @Autowired
    private JugadorMapper jugadorMapper;

    @Autowired
    private PartidoMapper partidoMapper;

    @Autowired
    private LigaService ligaService;

    public Equipo toModel(EquipoRequest request) {
        Equipo equipo = new Equipo();
        equipo.setNombre(request.getNombre());

        if (request.getLigaId() != null) {
            Liga liga = ligaService.getLigaEntityById(request.getLigaId());
            equipo.setLiga(liga);
        }
        return equipo;
    }

    public EquipoResponse toResponse(Equipo equipo) {
        EquipoResponse response = new EquipoResponse();
        response.setId(equipo.getId());
        response.setNombre(equipo.getNombre());

        if (equipo.getLiga() != null) {
            response.setLiga(ligaService.getLigaById(equipo.getLiga().getId()));
        }

        response.setJugadores(equipo.getJugadores().stream()
                .map(jugadorMapper::toResponse)
                .collect(Collectors.toSet()));

        response.setPartidosLocal(equipo.getPartidosLocal().stream()
                .map(partidoMapper::toResponse)
                .collect(Collectors.toSet()));

        response.setPartidosVisitante(equipo.getPartidosVisitante().stream()
                .map(partidoMapper::toResponse)
                .collect(Collectors.toSet()));

        return response;
    }

}

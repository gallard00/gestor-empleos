package com.example.empleos.Mappers;

import com.example.empleos.Dtos.*;
import com.example.empleos.Models.*;
import com.example.empleos.Services.EquipoService;
import com.example.empleos.Services.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartidoMapper {

    @Autowired
    private EquipoMapper equipoMapper;

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private LigaService ligaService;

    public Partido toModel(PartidoRequest request) {
        Partido partido = new Partido();
        partido.setGolesLocal(request.getGolesLocal());
        partido.setGolesVisitante(request.getGolesVisitante());
        partido.setFecha(request.getFecha());

        Equipo equipoLocal = equipoService.getEquipoEntityById(request.getEquipoLocalId());
        Equipo equipoVisitante = equipoService.getEquipoEntityById(request.getEquipoVisitanteId());
        Liga liga = ligaService.getLigaEntityById(request.getLigaId());

        partido.setEquipoLocal(equipoLocal);
        partido.setEquipoVisitante(equipoVisitante);
        partido.setLiga(liga);

        return partido;
    }

    public PartidoResponse toResponse(Partido partido) {
        PartidoResponse response = new PartidoResponse();
        response.setId(partido.getId());
        response.setGolesLocal(partido.getGolesLocal());
        response.setGolesVisitante(partido.getGolesVisitante());
        response.setFecha(partido.getFecha());

        if (partido.getEquipoLocal() != null) {
            response.setEquipoLocal(equipoMapper.toResponse(partido.getEquipoLocal()));
        }
        if (partido.getEquipoVisitante() != null) {
            response.setEquipoVisitante(equipoMapper.toResponse(partido.getEquipoVisitante()));
        }
        if (partido.getLiga() != null) {
            response.setLiga(ligaService.getLigaById(partido.getLiga().getId()));
        }

        return response;
    }
}

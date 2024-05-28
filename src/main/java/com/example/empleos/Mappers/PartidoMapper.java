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
    private EquipoService equipoService;

    @Autowired
    private LigaService ligaService;

    public Partido partidoRequestToPartido(PartidoRequest partidoRequest) {
        Partido partido = new Partido();
        partido.setFecha(partidoRequest.getFecha());
        partido.setGolesLocal(partidoRequest.getGolesLocal());
        partido.setGolesVisitante(partidoRequest.getGolesVisitante());

        // Set the associated entities
        Equipo equipoLocal = equipoService.getEquipoById(partidoRequest.getEquipoLocalId());
        Equipo equipoVisitante = equipoService.getEquipoById(partidoRequest.getEquipoVisitanteId());
        Liga liga = ligaService.getLigaById(partidoRequest.getLigaId());

        partido.setEquipoLocal(equipoLocal);
        partido.setEquipoVisitante(equipoVisitante);
        partido.setLiga(liga);

        return partido;
    }

    public PartidoResponse partidoToPartidoResponse(Partido partido) {
        PartidoResponse partidoResponse = new PartidoResponse();
        partidoResponse.setId(partido.getId());
        partidoResponse.setFecha(partido.getFecha());
        partidoResponse.setEquipoLocalId(partido.getEquipoLocal().getId());
        partidoResponse.setEquipoVisitanteId(partido.getEquipoVisitante().getId());
        partidoResponse.setGolesLocal(partido.getGolesLocal());
        partidoResponse.setGolesVisitante(partido.getGolesVisitante());
        partidoResponse.setLigaId(partido.getLiga().getId());
        return partidoResponse;
    }
}

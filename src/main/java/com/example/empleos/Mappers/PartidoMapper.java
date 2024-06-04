package com.example.empleos.Mappers;

import com.example.empleos.Dtos.*;
import com.example.empleos.Models.*;
import com.example.empleos.Services.EquipoService;
import com.example.empleos.Services.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PartidoMapper {

    @Autowired
    private EquipoService equipoService;

    public Partido partidoRequestToPartido(PartidoRequest request) {
        Equipo equipoLocal = equipoService.findEquipoById(request.getEquipoLocalId())
                .orElseThrow(() -> new RuntimeException("Equipo local no encontrado"));
        Equipo equipoVisitante = equipoService.findEquipoById(request.getEquipoVisitanteId())
                .orElseThrow(() -> new RuntimeException("Equipo visitante no encontrado"));

        return Partido.builder()
                .fecha(request.getFecha())
                .equipoLocal(equipoLocal)
                .equipoVisitante(equipoVisitante)
                .build();
    }

    public PartidoResponse partidoToPartidoResponse(Partido partido) {
        return PartidoResponse.builder()
                .id(partido.getId())
                .fecha(partido.getFecha())
                .equipoLocal(EquipoResponse.builder()
                        .id(partido.getEquipoLocal().getId())
                        .nombre(partido.getEquipoLocal().getNombre())
                        .build())
                .equipoVisitante(EquipoResponse.builder()
                        .id(partido.getEquipoVisitante().getId())
                        .nombre(partido.getEquipoVisitante().getNombre())
                        .build())
                .build();
    }
}

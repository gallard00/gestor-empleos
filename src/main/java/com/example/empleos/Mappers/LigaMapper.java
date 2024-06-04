package com.example.empleos.Mappers;

import com.example.empleos.Dtos.*;
import com.example.empleos.Models.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LigaMapper {

    public Liga ligaRequestToLiga(LigaRequest request) {
        return Liga.builder()
                .nombre(request.getNombre())
                .build();
    }

    public LigaResponse ligaToLigaResponse(Liga liga) {
        return LigaResponse.builder()
                .id(liga.getId())
                .nombre(liga.getNombre())
                .equipos(liga.getEquipos().stream()
                        .map(equipo -> EquipoResponse.builder()
                                .id(equipo.getId())
                                .nombre(equipo.getNombre())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}

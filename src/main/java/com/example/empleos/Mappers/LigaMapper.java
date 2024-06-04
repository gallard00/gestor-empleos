package com.example.empleos.Mappers;

import com.example.empleos.Dtos.*;
import com.example.empleos.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LigaMapper {

    @Autowired
    private EquipoMapper equipoMapper;

    public Liga toModel(LigaRequest request) {
        Liga liga = new Liga();
        liga.setNombre(request.getNombre());
        return liga;
    }

    public LigaResponse toResponse(Liga liga) {
        LigaResponse response = new LigaResponse();
        response.setId(liga.getId());
        response.setNombre(liga.getNombre());
        response.setEquipos(liga.getEquipos().stream()
                .map(equipoMapper::toResponse)
                .collect(Collectors.toSet()));
        return response;
    }
}

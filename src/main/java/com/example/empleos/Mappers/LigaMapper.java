package com.example.empleos.Mappers;

import com.example.empleos.Dtos.*;
import com.example.empleos.Models.*;
import org.springframework.stereotype.Component;

@Component
public class LigaMapper {

    public Liga toModel(LigaRequest request) {
        Liga liga = new Liga();
        liga.setNombre(request.getNombre());
        return liga;
    }

    public LigaResponse toResponse(Liga liga) {
        LigaResponse response = new LigaResponse();
        response.setId(liga.getId());
        response.setNombre(liga.getNombre());
        return response;
    }
}

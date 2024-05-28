package com.example.empleos.Mappers;

import com.example.empleos.Dtos.*;
import com.example.empleos.Models.*;
import org.springframework.stereotype.Component;

@Component
public class LigaMapper {
    public Liga ligaRequestToLiga(LigaRequest ligaRequest) {
        Liga liga = new Liga();
        liga.setNombre(ligaRequest.getNombre());
        return liga;
    }

    public LigaResponse ligaToLigaResponse(Liga liga) {
        LigaResponse ligaResponse = new LigaResponse();
        ligaResponse.setId(liga.getId());
        ligaResponse.setNombre(liga.getNombre());
        return ligaResponse;
    }
}

package com.example.empleos.Mappers;

import com.example.empleos.Dtos.EquipoRequest;
import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Dtos.LigaResponse;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Liga;
import com.example.empleos.Services.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquipoMapper {

    @Autowired
    private LigaService ligaService;

    public Equipo toModel(EquipoRequest request) {
        Equipo equipo = new Equipo();
        equipo.setNombre(request.getNombre());
        equipo.setPartidos(request.getPartidos());
        equipo.setGanados(request.getGanados());
        equipo.setEmpatados(request.getEmpatados());
        equipo.setPerdidos(request.getPerdidos());
        equipo.setGolesFavor(request.getGolesFavor());
        equipo.setGolesContra(request.getGolesContra());
        equipo.setDiferencia(request.getDiferencia());
        equipo.setPuntos(request.getPuntos());
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
        response.setPartidos(equipo.getPartidos());
        response.setGanados(equipo.getGanados());
        response.setEmpatados(equipo.getEmpatados());
        response.setPerdidos(equipo.getPerdidos());
        response.setGolesFavor(equipo.getGolesFavor());
        response.setGolesContra(equipo.getGolesContra());
        response.setDiferencia(equipo.getDiferencia());
        response.setPuntos(equipo.getPuntos());
        if (equipo.getLiga() != null) {
            response.setLigaId(equipo.getLiga().getId());
        }
        return response;
    }

}

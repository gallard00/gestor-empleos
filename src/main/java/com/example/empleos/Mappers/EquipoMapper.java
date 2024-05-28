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

    public Equipo equipoRequestToEquipo(EquipoRequest equipoRequest) {
        Equipo equipo = new Equipo();

        equipo.setNombre(equipoRequest.getNombre());
        equipo.setPartidos(equipoRequest.getPartidos());
        equipo.setGanados(equipoRequest.getGanados());
        equipo.setEmpatados(equipoRequest.getEmpatados());
        equipo.setPerdidos(equipoRequest.getPerdidos());
        equipo.setGolesFavor(equipoRequest.getGolesFavor());
        equipo.setGolesContra(equipoRequest.getGolesContra());
        equipo.setDiferencia(equipoRequest.getDiferencia());
        equipo.setPuntos(equipoRequest.getPuntos());

        Liga liga = ligaService.getLigaById(equipoRequest.getLigaId());

        equipo.setLiga(liga);

        return equipo;
    }

    public EquipoResponse equipoToEquipoResponse(Equipo equipo) {

        EquipoResponse equipoResponse = new EquipoResponse();

        equipoResponse.setId(equipo.getId());
        equipoResponse.setNombre(equipo.getNombre());
        equipoResponse.setPartidos(equipo.getPartidos());
        equipoResponse.setGanados(equipo.getGanados());
        equipoResponse.setEmpatados(equipo.getEmpatados());
        equipoResponse.setPerdidos(equipo.getPerdidos());
        equipoResponse.setDiferencia(equipo.getDiferencia());
        equipoResponse.setPuntos(equipo.getPuntos());
        equipoResponse.setLigaId(equipo.getLiga().getId());

        return equipoResponse;

    }

}

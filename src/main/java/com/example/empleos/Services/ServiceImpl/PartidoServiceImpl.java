package com.example.empleos.Services.ServiceImpl;


import com.example.empleos.Dtos.PartidoRequest;
import com.example.empleos.Dtos.PartidoResponse;
import com.example.empleos.Exceptions.ResourceNotFoundException;
import com.example.empleos.Mappers.PartidoMapper;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Liga;
import com.example.empleos.Models.Partido;
import com.example.empleos.Repositories.PartidoRepository;
import com.example.empleos.Services.EquipoService;
import com.example.empleos.Services.LigaService;
import com.example.empleos.Services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartidoServiceImpl implements PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private LigaService ligaService;

    @Autowired
    private PartidoMapper partidoMapper;

    @Override
    public PartidoResponse createPartido(PartidoRequest request) {
        Partido partido = partidoMapper.toModel(request);
        partido = partidoRepository.save(partido);
        return partidoMapper.toResponse(partido);
    }

    @Override
    public PartidoResponse getPartidoById(Long id) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
        return partidoMapper.toResponse(partido);
    }

    @Override
    public Partido getPartidoEntityById(Long id) {  // Método adicional
        return partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
    }

    @Override
    public List<PartidoResponse> getAllPartidos() {
        return partidoRepository.findAll().stream()
                .map(partidoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PartidoResponse updatePartido(Long id, PartidoRequest request) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
        if (request.getEquipoLocalId() != null) {
            Equipo equipoLocal = equipoService.getEquipoEntityById(request.getEquipoLocalId());
            partido.setEquipoLocal(equipoLocal);
        }
        if (request.getEquipoVisitanteId() != null) {
            Equipo equipoVisitante = equipoService.getEquipoEntityById(request.getEquipoVisitanteId());
            partido.setEquipoVisitante(equipoVisitante);
        }
        if (request.getLigaId() != null) {
            Liga liga = ligaService.getLigaEntityById(request.getLigaId());
            partido.setLiga(liga);
        }
        partido.setGolesLocal(request.getGolesLocal());
        partido.setGolesVisitante(request.getGolesVisitante());
        partido.setFecha(request.getFecha());
        partido = partidoRepository.save(partido);
        return partidoMapper.toResponse(partido);
    }

    @Override
    public void deletePartido(Long id) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
        partidoRepository.delete(partido);
    }
}

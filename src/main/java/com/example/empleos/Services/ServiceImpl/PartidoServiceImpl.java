package com.example.empleos.Services.ServiceImpl;


import com.example.empleos.Dtos.PartidoRequest;
import com.example.empleos.Dtos.PartidoResponse;
import com.example.empleos.Exceptions.ResourceNotFoundException;
import com.example.empleos.Mappers.PartidoMapper;
import com.example.empleos.Models.Partido;
import com.example.empleos.Repositories.PartidoRepository;
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
    private PartidoMapper partidoMapper;

    @Override
    public List<PartidoResponse> getAllPartidos() {
        return partidoRepository.findAll().stream()
                .map(partidoMapper::partidoToPartidoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PartidoResponse getPartidoById(Long id) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partido not found with id: " + id));
        return partidoMapper.partidoToPartidoResponse(partido);
    }

    @Override
    public PartidoResponse createPartido(PartidoRequest partidoRequest) {
        Partido partido = partidoMapper.partidoRequestToPartido(partidoRequest);
        partido = partidoRepository.save(partido);
        return partidoMapper.partidoToPartidoResponse(partido);
    }

    @Override
    public PartidoResponse updatePartido(Long id, PartidoRequest partidoRequest) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partido not found with id: " + id));

        // Update the fields
        partido.setFecha(partidoRequest.getFecha());
        partido.setGolesLocal(partidoRequest.getGolesLocal());
        partido.setGolesVisitante(partidoRequest.getGolesVisitante());

        // Update the associations
        partido.setEquipoLocal(equipoService.getEquipoById(partidoRequest.getEquipoLocalId()));
        partido.setEquipoVisitante(equipoService.getEquipoById(partidoRequest.getEquipoVisitanteId()));
        partido.setLiga(ligaService.getLigaById(partidoRequest.getLigaId()));

        partido = partidoRepository.save(partido);
        return partidoMapper.partidoToPartidoResponse(partido);
    }

    @Override
    public void deletePartido(Long id) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partido not found with id: " + id));
        partidoRepository.delete(partido);
    }
}

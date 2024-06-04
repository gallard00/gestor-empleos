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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidoServiceImpl implements PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private PartidoMapper partidoMapper;

    @Autowired
    private EquipoService equipoService;

    @Override
    public PartidoResponse createPartido(PartidoRequest request) {
        Partido partido = partidoMapper.partidoRequestToPartido(request);
        partido = partidoRepository.save(partido);
        return partidoMapper.partidoToPartidoResponse(partido);
    }

    @Override
    public List<PartidoResponse> getAllPartidos() {
        return partidoRepository.findAll().stream()
                .map(partidoMapper::partidoToPartidoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PartidoResponse getPartidoById(Long id) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
        return partidoMapper.partidoToPartidoResponse(partido);
    }

    @Override
    public PartidoResponse updatePartido(Long id, PartidoRequest request) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));

        partido.setFecha(request.getFecha());

        if (request.getEquipoLocalId() != null) {
            partido.setEquipoLocal(equipoService.findEquipoById(request.getEquipoLocalId())
                    .orElseThrow(() -> new RuntimeException("Equipo local no encontrado")));
        }

        if (request.getEquipoVisitanteId() != null) {
            partido.setEquipoVisitante(equipoService.findEquipoById(request.getEquipoVisitanteId())
                    .orElseThrow(() -> new RuntimeException("Equipo visitante no encontrado")));
        }

        partidoRepository.save(partido);
        return partidoMapper.partidoToPartidoResponse(partido);
    }

    @Override
    public void deletePartido(Long id) {
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
        partidoRepository.delete(partido);
    }

    @Override
    public Optional<Partido> findPartidoById(Long id) {
        return partidoRepository.findById(id);
    }
}

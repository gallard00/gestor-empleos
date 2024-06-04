package com.example.empleos.Services.ServiceImpl;

import com.example.empleos.Dtos.EquipoRequest;
import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Exceptions.ResourceNotFoundException;
import com.example.empleos.Mappers.EquipoMapper;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Liga;
import com.example.empleos.Repositories.EquipoRepository;
import com.example.empleos.Repositories.LigaRepository;
import com.example.empleos.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private LigaRepository ligaRepository;

    @Autowired
    private EquipoMapper equipoMapper;

    @Override
    public EquipoResponse createEquipo(EquipoRequest request) {
        Equipo equipo = equipoMapper.toModel(request);
        equipo = equipoRepository.save(equipo);
        return equipoMapper.toResponse(equipo);
    }

    @Override
    public EquipoResponse getEquipoById(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        return equipoMapper.toResponse(equipo);
    }

    @Override
    public Equipo getEquipoEntityById(Long id) {  // Método adicional
        return equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }

    @Override
    public List<EquipoResponse> getAllEquipos() {
        return equipoRepository.findAll().stream()
                .map(equipoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoResponse updateEquipo(Long id, EquipoRequest request) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        equipo.setNombre(request.getNombre());
        if (request.getLigaId() != null) {
            Liga liga = ligaRepository.findById(request.getLigaId())
                    .orElseThrow(() -> new RuntimeException("Liga no encontrada"));
            equipo.setLiga(liga);
        }
        equipo = equipoRepository.save(equipo);
        return equipoMapper.toResponse(equipo);
    }

    @Override
    public void deleteEquipo(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        equipoRepository.delete(equipo);
    }
}

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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private EquipoMapper equipoMapper;

    @Autowired
    private LigaService ligaService;

    @Override
    public EquipoResponse createEquipo(EquipoRequest request) {
        Equipo equipo = equipoMapper.equipoRequestToEquipo(request);
        equipo = equipoRepository.save(equipo);
        return equipoMapper.equipoToEquipoResponse(equipo);
    }

    @Override
    public List<EquipoResponse> getAllEquipos() {
        return equipoRepository.findAll().stream()
                .map(equipoMapper::equipoToEquipoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoResponse getEquipoById(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        return equipoMapper.equipoToEquipoResponse(equipo);
    }

    @Override
    public EquipoResponse updateEquipo(Long id, EquipoRequest request) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        equipo.setNombre(request.getNombre());

        if (request.getLigaId() != null) {
            equipo.setLiga(ligaService.findLigaById(request.getLigaId())
                    .orElseThrow(() -> new RuntimeException("Liga no encontrada")));
        }

        equipoRepository.save(equipo);
        return equipoMapper.equipoToEquipoResponse(equipo);
    }

    @Override
    public void deleteEquipo(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        equipoRepository.delete(equipo);
    }

    @Override
    public Optional<Equipo> findEquipoById(Long id) {
        return equipoRepository.findById(id);
    }
}

package com.example.empleos.Services.ServiceImpl;

import com.example.empleos.Dtos.EquipoRequest;
import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Exceptions.ResourceNotFoundException;
import com.example.empleos.Mappers.EquipoMapper;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Repositories.EquipoRepository;
import com.example.empleos.Services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class EquipoServiceImpl implements EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private EquipoMapper equipoMapper;

    @Override
    public List<EquipoResponse> getAllEquipos() {
        return equipoRepository.findAll().stream()
                .map(equipoMapper::equipoToEquipoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoResponse getEquipoById(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo not found with id: " + id));
        return equipoMapper.equipoToEquipoResponse(equipo);
    }

    @Override
    public EquipoResponse createEquipo(EquipoRequest equipoRequest) {
        Equipo equipo = equipoMapper.equipoRequestToEquipo(equipoRequest);
        equipo = equipoRepository.save(equipo);
        return equipoMapper.equipoToEquipoResponse(equipo);
    }

    @Override
    public EquipoResponse updateEquipo(Long id, EquipoRequest equipoRequest) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo not found with id: " + id));
        equipo.setNombre(equipoRequest.getNombre());
        equipo = equipoRepository.save(equipo);
        return equipoMapper.equipoToEquipoResponse(equipo);
    }

    @Override
    public void deleteEquipo(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo not found with id: " + id));
        equipoRepository.delete(equipo);
    }
}

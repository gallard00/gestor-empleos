package com.example.empleos.Services.ServiceImpl;

import com.example.empleos.Dtos.*;
import com.example.empleos.Exceptions.ResourceNotFoundException;
import com.example.empleos.Mappers.LigaMapper;
import com.example.empleos.Models.Liga;
import com.example.empleos.Models.Partido;
import com.example.empleos.Repositories.LigaRepository;
import com.example.empleos.Services.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LigaServiceImpl implements LigaService {
    @Autowired
    private LigaRepository ligaRepository;

    @Autowired
    private LigaMapper ligaMapper;

    @Override
    public LigaResponse createLiga(LigaRequest request) {
        Liga liga = ligaMapper.toModel(request);
        liga = ligaRepository.save(liga);
        return ligaMapper.toResponse(liga);
    }

    @Override
    public LigaResponse getLigaById(Long id) {
        Liga liga = ligaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liga no encontrada"));
        return ligaMapper.toResponse(liga);
    }

    @Override
    public Liga getLigaEntityById(Long id) {  // Método adicional
        return ligaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liga no encontrado"));
    }

    @Override
    public List<LigaResponse> getAllLigas() {
        return ligaRepository.findAll().stream()
                .map(ligaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LigaResponse updateLiga(Long id, LigaRequest request) {
        Liga liga = ligaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liga no encontrada"));
        liga.setNombre(request.getNombre());
        liga = ligaRepository.save(liga);
        return ligaMapper.toResponse(liga);
    }

    @Override
    public void deleteLiga(Long id) {
        Liga liga = ligaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liga no encontrada"));
        ligaRepository.delete(liga);
    }
}

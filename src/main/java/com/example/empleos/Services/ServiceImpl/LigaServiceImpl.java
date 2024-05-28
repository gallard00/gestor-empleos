package com.example.empleos.Services.ServiceImpl;

import com.example.empleos.Dtos.*;
import com.example.empleos.Exceptions.ResourceNotFoundException;
import com.example.empleos.Mappers.LigaMapper;
import com.example.empleos.Models.Liga;
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
    public List<LigaResponse> getAllLigas() {
        return ligaRepository.findAll().stream()
                .map(ligaMapper::ligaToLigaResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LigaResponse getLigaById(Long id) {
        Liga liga = ligaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Liga not found with id: " + id));
        return ligaMapper.ligaToLigaResponse(liga);
    }

    @Override
    public LigaResponse createLiga(LigaRequest ligaRequest) {
        Liga liga = ligaMapper.ligaRequestToLiga(ligaRequest);
        liga = ligaRepository.save(liga);
        return ligaMapper.ligaToLigaResponse(liga);
    }

    @Override
    public LigaResponse updateLiga(Long id, LigaRequest ligaRequest) {
        Liga liga = ligaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Liga not found with id: " + id));
        liga.setNombre(ligaRequest.getNombre());
        liga = ligaRepository.save(liga);
        return ligaMapper.ligaToLigaResponse(liga);
    }

    @Override
    public void deleteLiga(Long id) {
        Liga liga = ligaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Liga not found with id: " + id));
        ligaRepository.delete(liga);
    }
}

package com.example.empleos.Services;
import com.example.empleos.Dtos.LigaRequest;
import com.example.empleos.Dtos.LigaResponse;
import com.example.empleos.Mappers.LigaMapper;
import com.example.empleos.Models.Liga;
import com.example.empleos.Repositories.LigaRepository;
import com.example.empleos.Services.ServiceImpl.LigaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LigaServiceTest {/*
    @Mock
    private LigaRepository ligaRepository;

    @Mock
    private LigaMapper ligaMapper;

    @InjectMocks
    private LigaServiceImpl ligaService;

    private Liga liga;
    private LigaRequest ligaRequest;
    private LigaResponse ligaResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        liga = Liga.builder()
                .id(1L)
                .nombre("Liga1")
                .build();
        ligaRequest = LigaRequest.builder()
                .nombre("Liga1")
                .build();
        ligaResponse = LigaResponse.builder()
                .id(1L)
                .nombre("Liga1")
                .build();
    }

    @Test
    void createLiga() {
        when(ligaMapper.ligaRequestToLiga(ligaRequest)).thenReturn(liga);
        when(ligaRepository.save(liga)).thenReturn(liga);
        when(ligaMapper.ligaToLigaResponse(liga)).thenReturn(ligaResponse);

        LigaResponse response = ligaService.createLiga(ligaRequest);

        assertNotNull(response);
        assertEquals(ligaResponse.getNombre(), response.getNombre());
        verify(ligaRepository, times(1)).save(liga);
    }

    @Test
    void getLigaById() {
        when(ligaRepository.findById(1L)).thenReturn(Optional.of(liga));
        when(ligaMapper.ligaToLigaResponse(liga)).thenReturn(ligaResponse);

        LigaResponse response = ligaService.getLigaById(1L);

        assertNotNull(response);
        assertEquals(ligaResponse.getNombre(), response.getNombre());
        verify(ligaRepository, times(1)).findById(1L);
    }

    @Test
    void updateLiga() {
        when(ligaRepository.findById(1L)).thenReturn(Optional.of(liga));
        when(ligaRepository.save(liga)).thenReturn(liga);
        when(ligaMapper.ligaToLigaResponse(liga)).thenReturn(ligaResponse);

        LigaResponse response = ligaService.updateLiga(1L, ligaRequest);

        assertNotNull(response);
        assertEquals(ligaResponse.getNombre(), response.getNombre());
        verify(ligaRepository, times(1)).save(liga);
    }

    @Test
    void deleteLiga() {
        when(ligaRepository.findById(1L)).thenReturn(Optional.of(liga));

        ligaService.deleteLiga(1L);

        verify(ligaRepository, times(1)).delete(liga);
    }*/
}

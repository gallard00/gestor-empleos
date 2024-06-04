package com.example.empleos.Services;
import com.example.empleos.Dtos.PartidoRequest;
import com.example.empleos.Dtos.PartidoResponse;
import com.example.empleos.Mappers.PartidoMapper;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Partido;
import com.example.empleos.Repositories.PartidoRepository;
import com.example.empleos.Services.ServiceImpl.PartidoServiceImpl;
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
public class PartidoServiceTest {/*
    @Mock
    private PartidoRepository partidoRepository;

    @Mock
    private PartidoMapper partidoMapper;

    @InjectMocks
    private PartidoServiceImpl partidoService;

    private Partido partido;
    private PartidoRequest partidoRequest;
    private PartidoResponse partidoResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        partido = Partido.builder()
                .id(1L)
                .equipoLocal(Equipo.builder().id(1L).nombre("Equipo1").build())
                .equipoVisitante(Equipo.builder().id(2L).nombre("Equipo2").build())
                .build();
        partidoRequest = PartidoRequest.builder()
                .equipoLocalId(1L)
                .equipoVisitanteId(2L)
                .build();
        partidoResponse = PartidoResponse.builder()
                .id(1L)
                .equipoLocalNombre("Equipo1")
                .equipoVisitanteNombre("Equipo2")
                .build();
    }

    @Test
    void createPartido() {
        when(partidoMapper.partidoRequestToPartido(partidoRequest)).thenReturn(partido);
        when(partidoRepository.save(partido)).thenReturn(partido);
        when(partidoMapper.partidoToPartidoResponse(partido)).thenReturn(partidoResponse);

        PartidoResponse response = partidoService.createPartido(partidoRequest);

        assertNotNull(response);
        assertEquals(partidoResponse.getEquipoLocalNombre(), response.getEquipoLocalNombre());
        verify(partidoRepository, times(1)).save(partido);
    }

    @Test
    void getPartidoById() {
        when(partidoRepository.findById(1L)).thenReturn(Optional.of(partido));
        when(partidoMapper.partidoToPartidoResponse(partido)).thenReturn(partidoResponse);

        PartidoResponse response = partidoService.getPartidoById(1L);

        assertNotNull(response);
        assertEquals(partidoResponse.getEquipoLocalNombre(), response.getEquipoLocalNombre());
        verify(partidoRepository, times(1)).findById(1L);
    }

    @Test
    void updatePartido() {
        when(partidoRepository.findById(1L)).thenReturn(Optional.of(partido));
        when(partidoRepository.save(partido)).thenReturn(partido);
        when(partidoMapper.partidoToPartidoResponse(partido)).thenReturn(partidoResponse);

        PartidoResponse response = partidoService.updatePartido(1L, partidoRequest);

        assertNotNull(response);
        assertEquals(partidoResponse.getEquipoLocalNombre(), response.getEquipoLocalNombre());
        verify(partidoRepository, times(1)).save(partido);
    }

    @Test
    void deletePartido() {
        when(partidoRepository.findById(1L)).thenReturn(Optional.of(partido));

        partidoService.deletePartido(1L);

        verify(partidoRepository, times(1)).delete(partido);
    }*/
}

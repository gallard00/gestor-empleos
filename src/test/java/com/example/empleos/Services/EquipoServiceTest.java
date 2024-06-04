package com.example.empleos.Services;

import com.example.empleos.Dtos.EquipoRequest;
import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Mappers.EquipoMapper;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Liga;
import com.example.empleos.Repositories.EquipoRepository;
import com.example.empleos.Services.ServiceImpl.EquipoServiceImpl;
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
public class EquipoServiceTest {
    /*
    @Mock
    private EquipoRepository equipoRepository;

    @Mock
    private EquipoMapper equipoMapper;

    @InjectMocks
    private EquipoServiceImpl equipoService;

    private Equipo equipo;
    private EquipoRequest equipoRequest;
    private EquipoResponse equipoResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        equipo = Equipo.builder()
                .id(1L)
                .nombre("Equipo1")
                .liga(Liga.builder().id(1L).nombre("Liga1").build())
                .build();
        equipoRequest = EquipoRequest.builder()
                .nombre("Equipo1")
                .ligaId(1L)
                .build();
        equipoResponse = EquipoResponse.builder()
                .id(1L)
                .nombre("Equipo1")
                .ligaNombre("Liga1")
                .build();
    }

    @Test
    void createEquipo() {
        when(equipoMapper.equipoRequestToEquipo(equipoRequest)).thenReturn(equipo);
        when(equipoRepository.save(equipo)).thenReturn(equipo);
        when(equipoMapper.equipoToEquipoResponse(equipo)).thenReturn(equipoResponse);

        EquipoResponse response = equipoService.createEquipo(equipoRequest);

        assertNotNull(response);
        assertEquals(equipoResponse.getNombre(), response.getNombre());
        verify(equipoRepository, times(1)).save(equipo);
    }

    @Test
    void getEquipoById() {
        when(equipoRepository.findById(1L)).thenReturn(Optional.of(equipo));
        when(equipoMapper.equipoToEquipoResponse(equipo)).thenReturn(equipoResponse);

        EquipoResponse response = equipoService.getEquipoById(1L);

        assertNotNull(response);
        assertEquals(equipoResponse.getNombre(), response.getNombre());
        verify(equipoRepository, times(1)).findById(1L);
    }

    @Test
    void updateEquipo() {
        when(equipoRepository.findById(1L)).thenReturn(Optional.of(equipo));
        when(equipoRepository.save(equipo)).thenReturn(equipo);
        when(equipoMapper.equipoToEquipoResponse(equipo)).thenReturn(equipoResponse);

        EquipoResponse response = equipoService.updateEquipo(1L, equipoRequest);

        assertNotNull(response);
        assertEquals(equipoResponse.getNombre(), response.getNombre());
        verify(equipoRepository, times(1)).save(equipo);
    }

    @Test
    void deleteEquipo() {
        when(equipoRepository.findById(1L)).thenReturn(Optional.of(equipo));

        equipoService.deleteEquipo(1L);

        verify(equipoRepository, times(1)).delete(equipo);
    }*/
}

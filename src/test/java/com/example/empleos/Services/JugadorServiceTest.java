package com.example.empleos.Services;
import com.example.empleos.Dtos.JugadorRequest;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Mappers.JugadorMapper;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Jugador;
import com.example.empleos.Repositories.JugadorRepository;
import com.example.empleos.Services.ServiceImpl.JugadorServiceImpl;
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
public class JugadorServiceTest { /*
    @Mock
    private JugadorRepository jugadorRepository;

    @Mock
    private JugadorMapper jugadorMapper;

    @InjectMocks
    private JugadorServiceImpl jugadorService;

    private Jugador jugador;
    private JugadorRequest jugadorRequest;
    private JugadorResponse jugadorResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        jugador = Jugador.builder()
                .id(1L)
                .nombre("Jugador1")
                .equipo(Equipo.builder().id(1L).nombre("Equipo1").build())
                .build();
        jugadorRequest = JugadorRequest.builder()
                .nombre("Jugador1")
                .equipoId(1L)
                .build();
        jugadorResponse = JugadorResponse.builder()
                .id(1L)
                .nombre("Jugador1")
                .equipoNombre("Equipo1")
                .build();
    }

    @Test
    void createJugador() {
        when(jugadorMapper.jugadorRequestToJugador(jugadorRequest)).thenReturn(jugador);
        when(jugadorRepository.save(jugador)).thenReturn(jugador);
        when(jugadorMapper.jugadorToJugadorResponse(jugador)).thenReturn(jugadorResponse);

        JugadorResponse response = jugadorService.createJugador(jugadorRequest);

        assertNotNull(response);
        assertEquals(jugadorResponse.getNombre(), response.getNombre());
        verify(jugadorRepository, times(1)).save(jugador);
    }

    @Test
    void getJugadorById() {
        when(jugadorRepository.findById(1L)).thenReturn(Optional.of(jugador));
        when(jugadorMapper.jugadorToJugadorResponse(jugador)).thenReturn(jugadorResponse);

        JugadorResponse response = jugadorService.getJugadorById(1L);

        assertNotNull(response);
        assertEquals(jugadorResponse.getNombre(), response.getNombre());
        verify(jugadorRepository, times(1)).findById(1L);
    }

    @Test
    void updateJugador() {
        when(jugadorRepository.findById(1L)).thenReturn(Optional.of(jugador));
        when(jugadorRepository.save(jugador)).thenReturn(jugador);
        when(jugadorMapper.jugadorToJugadorResponse(jugador)).thenReturn(jugadorResponse);

        JugadorResponse response = jugadorService.updateJugador(1L, jugadorRequest);

        assertNotNull(response);
        assertEquals(jugadorResponse.getNombre(), response.getNombre());
        verify(jugadorRepository, times(1)).save(jugador);
    }

    @Test
    void deleteJugador() {
        when(jugadorRepository.findById(1L)).thenReturn(Optional.of(jugador));

        jugadorService.deleteJugador(1L);

        verify(jugadorRepository, times(1)).delete(jugador);
    }*/
}

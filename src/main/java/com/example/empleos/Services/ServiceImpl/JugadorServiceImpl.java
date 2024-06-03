package com.example.empleos.Services.ServiceImpl;

import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Dtos.JugadorRequest;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Exceptions.ResourceNotFoundException;
import com.example.empleos.Mappers.JugadorMapper;
import com.example.empleos.Models.Equipo;
import com.example.empleos.Models.Jugador;
import com.example.empleos.Repositories.JugadorRepository;
import com.example.empleos.Services.EquipoService;
import com.example.empleos.Services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JugadorServiceImpl implements JugadorService{
    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private JugadorMapper jugadorMapper;

    @Override
    public JugadorResponse createJugador(JugadorRequest request) {
        Jugador jugador = jugadorMapper.toModel(request);
        jugador = jugadorRepository.save(jugador);
        return jugadorMapper.toResponse(jugador);
    }

    @Override
    public JugadorResponse getJugadorById(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        return jugadorMapper.toResponse(jugador);
    }

    @Override
    public Jugador getJugadorEntityById(Long id) {  // Método adicional
        return jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }

    @Override
    public List<JugadorResponse> getAllJugadores() {
        return jugadorRepository.findAll().stream()
                .map(jugadorMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public JugadorResponse updateJugador(Long id, JugadorRequest request) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        if (request.getEquipoId() != null) {
            Equipo equipo = equipoService.getEquipoEntityById(request.getEquipoId());
            jugador.setEquipo(equipo);
        }
        jugador.setNombre(request.getNombre());
        jugador.setApellido(request.getApellido());
        jugador.setPosicion(request.getPosicion());
        jugador = jugadorRepository.save(jugador);
        return jugadorMapper.toResponse(jugador);
    }

    @Override
    public void deleteJugador(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        jugadorRepository.delete(jugador);
    }
}

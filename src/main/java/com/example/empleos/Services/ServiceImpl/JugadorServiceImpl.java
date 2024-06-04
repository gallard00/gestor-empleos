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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorServiceImpl implements JugadorService{
    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private JugadorMapper jugadorMapper;

    @Autowired
    private EquipoService equipoService;

    @Override
    public JugadorResponse createJugador(JugadorRequest request) {
        Jugador jugador = jugadorMapper.jugadorRequestToJugador(request);
        jugador = jugadorRepository.save(jugador);
        return jugadorMapper.jugadorToJugadorResponse(jugador);
    }

    @Override
    public List<JugadorResponse> getAllJugadores() {
        return jugadorRepository.findAll().stream()
                .map(jugadorMapper::jugadorToJugadorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public JugadorResponse getJugadorById(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        return jugadorMapper.jugadorToJugadorResponse(jugador);
    }

    @Override
    public JugadorResponse updateJugador(Long id, JugadorRequest request) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

        jugador.setNombre(request.getNombre());

        if (request.getEquipoId() != null) {
            jugador.setEquipo(equipoService.findEquipoById(request.getEquipoId())
                    .orElseThrow(() -> new RuntimeException("Equipo no encontrado")));
        }

        jugadorRepository.save(jugador);
        return jugadorMapper.jugadorToJugadorResponse(jugador);
    }

    @Override
    public void deleteJugador(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        jugadorRepository.delete(jugador);
    }

    @Override
    public Optional<Jugador> findJugadorById(Long id) {
        return jugadorRepository.findById(id);
    }
}

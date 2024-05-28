package com.example.empleos.Services.ServiceImpl;

import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Dtos.JugadorRequest;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Exceptions.ResourceNotFoundException;
import com.example.empleos.Mappers.JugadorMapper;
import com.example.empleos.Models.Jugador;
import com.example.empleos.Repositories.JugadorRepository;
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
    private JugadorMapper jugadorMapper;

    @Override
    public List<JugadorResponse> getAllJugadores() {
        return jugadorRepository.findAll().stream()
                .map(jugadorMapper::jugadorToJugadorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public JugadorResponse getJugadorById(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jugador not found with id: " + id));
        return jugadorMapper.jugadorToJugadorResponse(jugador);
    }

    @Override
    public JugadorResponse createJugador (JugadorRequest jugadorRequest) {
        Jugador jugador = jugadorMapper.jugadorRequestToJugador(jugadorRequest);
        jugador = jugadorRepository.save(jugador);
        return jugadorMapper.jugadorToJugadorResponse(jugador);
    }

    @Override
    public JugadorResponse updateJugador (Long id, JugadorRequest jugadorRequest) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jugador not found with id: " + id));
        jugador.setNombre(jugadorRequest.getNombre());
        jugador.setApellido(jugadorRequest.getApellido());
        jugador.setPosicion(jugadorRequest.getPosicion());

        jugador = jugadorRepository.save(jugador);
        return jugadorMapper.jugadorToJugadorResponse(jugador);
    }

    @Override
    public void  deleteJugador(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jugador not found with id: " + id));
        jugadorRepository.delete(jugador);
    }
}

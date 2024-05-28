package com.example.empleos.Controllers;

import com.example.empleos.Dtos.JugadorRequest;
import com.example.empleos.Dtos.JugadorResponse;
import com.example.empleos.Services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {
    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<JugadorResponse> getAllJugadores() {
        return jugadorService.getAllJugadores();
    }

    @GetMapping("/{id}")
    public JugadorResponse getJugadorById(@PathVariable Long id) {
        return jugadorService.getJugadorById(id);
    }

    @PostMapping
    public JugadorResponse createJugador(@RequestBody JugadorRequest jugadorRequest) {
        return jugadorService.createJugador(jugadorRequest);
    }

    @PutMapping("/{id}")
    public JugadorResponse updateJugador(@PathVariable Long id, @RequestBody JugadorRequest jugadorRequest) {
        return jugadorService.updateJugador(id, jugadorRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJugador(@PathVariable Long id) {
        jugadorService.deleteJugador(id);
        return ResponseEntity.ok("Jugador eliminado con ID: " + id);
    }
}

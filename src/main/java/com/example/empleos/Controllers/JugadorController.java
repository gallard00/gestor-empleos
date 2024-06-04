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

    @PostMapping
    public ResponseEntity<JugadorResponse> createJugador(@RequestBody JugadorRequest request) {
        return ResponseEntity.ok(jugadorService.createJugador(request));
    }

    @GetMapping
    public ResponseEntity<List<JugadorResponse>> getAllJugadores() {
        return ResponseEntity.ok(jugadorService.getAllJugadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorResponse> getJugadorById(@PathVariable Long id) {
        return ResponseEntity.ok(jugadorService.getJugadorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorResponse> updateJugador(@PathVariable Long id, @RequestBody JugadorRequest request) {
        return ResponseEntity.ok(jugadorService.updateJugador(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJugador(@PathVariable Long id) {
        jugadorService.deleteJugador(id);
        return ResponseEntity.noContent().build();
    }
}

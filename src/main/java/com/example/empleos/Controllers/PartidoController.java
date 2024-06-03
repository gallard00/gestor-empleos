package com.example.empleos.Controllers;

import com.example.empleos.Dtos.PartidoRequest;
import com.example.empleos.Dtos.PartidoResponse;
import com.example.empleos.Services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public ResponseEntity<PartidoResponse> createPartido(@RequestBody PartidoRequest request) {
        return ResponseEntity.ok(partidoService.createPartido(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoResponse> getPartidoById(@PathVariable Long id) {
        return ResponseEntity.ok(partidoService.getPartidoById(id));
    }

    @GetMapping
    public ResponseEntity<List<PartidoResponse>> getAllPartidos() {
        return ResponseEntity.ok(partidoService.getAllPartidos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidoResponse> updatePartido(@PathVariable Long id, @RequestBody PartidoRequest request) {
        return ResponseEntity.ok(partidoService.updatePartido(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartido(@PathVariable Long id) {
        partidoService.deletePartido(id);
        return ResponseEntity.noContent().build();
    }
}

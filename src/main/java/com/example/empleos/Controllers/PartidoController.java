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

    @GetMapping
    public List<PartidoResponse> getAllPartidos(){
        return partidoService.getAllPartidos();
    }

    @GetMapping("/{id}")
    public PartidoResponse getPartidoById(@PathVariable Long id) {
        return partidoService.getPartidoById(id);
    }

    @PostMapping
    public PartidoResponse createPartido(@RequestBody PartidoRequest partidoRequest) {
        return partidoService.createPartido(partidoRequest);
    }

    @PutMapping("/{id}")
    public PartidoResponse updatePartido(@PathVariable Long id, @RequestBody PartidoRequest partidoRequest) {
        return partidoService.updatePartido(id, partidoRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePartido(@PathVariable Long id) {
        partidoService.deletePartido(id);
        return ResponseEntity.ok("Partido eliminado con ID: " + id);
    }
}

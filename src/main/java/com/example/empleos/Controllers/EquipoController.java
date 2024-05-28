package com.example.empleos.Controllers;

import com.example.empleos.Dtos.EquipoRequest;
import com.example.empleos.Dtos.EquipoResponse;
import com.example.empleos.Services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<EquipoResponse> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    @GetMapping("/{id}")
    public EquipoResponse getEquipoById(@PathVariable Long id) {
        return equipoService.getEquipoById(id);
    }

    @PostMapping
    public EquipoResponse createEquipo(@RequestBody EquipoRequest equipoRequest) {
        return equipoService.createEquipo(equipoRequest);
    }

    @PutMapping("/{id}")
    public EquipoResponse updateEquipo(@PathVariable Long id, @RequestBody EquipoRequest equipoRequest) {
        return equipoService.updateEquipo(id, equipoRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEquipo(@PathVariable Long id) {
        equipoService.deleteEquipo(id);
        return ResponseEntity.ok("Equipo eliminado con ID: " + id);
    }
}

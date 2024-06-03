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

    @PostMapping
    public ResponseEntity<EquipoResponse> createEquipo(@RequestBody EquipoRequest request) {
        return ResponseEntity.ok(equipoService.createEquipo(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoResponse> getEquipoById(@PathVariable Long id) {
        return ResponseEntity.ok(equipoService.getEquipoById(id));
    }

    @GetMapping
    public ResponseEntity<List<EquipoResponse>> getAllEquipos() {
        return ResponseEntity.ok(equipoService.getAllEquipos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipoResponse> updateEquipo(@PathVariable Long id, @RequestBody EquipoRequest request) {
        return ResponseEntity.ok(equipoService.updateEquipo(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
        equipoService.deleteEquipo(id);
        return ResponseEntity.noContent().build();
    }
}

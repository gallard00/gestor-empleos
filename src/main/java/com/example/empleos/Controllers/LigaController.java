package com.example.empleos.Controllers;

import com.example.empleos.Dtos.LigaRequest;
import com.example.empleos.Dtos.LigaResponse;
import com.example.empleos.Services.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ligas")
public class LigaController {
    @Autowired
    private LigaService ligaService;

    @PostMapping
    public ResponseEntity<LigaResponse> createLiga(@RequestBody LigaRequest request) {
        return ResponseEntity.ok(ligaService.createLiga(request));
    }

    @GetMapping
    public ResponseEntity<List<LigaResponse>> getAllLigas() {
        return ResponseEntity.ok(ligaService.getAllLigas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigaResponse> getLigaById(@PathVariable Long id) {
        return ResponseEntity.ok(ligaService.getLigaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigaResponse> updateLiga(@PathVariable Long id, @RequestBody LigaRequest request) {
        return ResponseEntity.ok(ligaService.updateLiga(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLiga(@PathVariable Long id) {
        ligaService.deleteLiga(id);
        return ResponseEntity.noContent().build();
    }
}

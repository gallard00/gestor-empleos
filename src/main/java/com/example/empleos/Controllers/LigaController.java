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

    @GetMapping
    public List<LigaResponse> getAllLigas() {
        return ligaService.getAllLigas();
    }

    @GetMapping("/{id}")
    public LigaResponse getLigaById(@PathVariable Long id) {
        return ligaService.getLigaById(id);
    }

    @PostMapping
    public LigaResponse createLiga(@RequestBody LigaRequest ligaRequest) {
        return ligaService.createLiga(ligaRequest);
    }

    @PutMapping("/{id}")
    public LigaResponse updateLiga(@PathVariable Long id, @RequestBody LigaRequest ligaRequest) {
        return ligaService.updateLiga(id, ligaRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLiga(@PathVariable Long id) {
        ligaService.deleteLiga(id);
        return ResponseEntity.ok("Liga eliminada con ID: " + id);
    }
}

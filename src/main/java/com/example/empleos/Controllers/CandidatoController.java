package com.example.empleos.Controllers;

    import com.example.empleos.Dtos.CandidatoResponse;
    import com.example.empleos.Dtos.CandidatoRequest;
    import com.example.empleos.Services.CandidatoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    @PostMapping
    public ResponseEntity<CandidatoResponse> createCandidato(@RequestBody CandidatoRequest candidatoRequest) {
        return ResponseEntity.ok(candidatoService.saveCandidato(candidatoRequest));
    }

    @GetMapping
    public ResponseEntity<List<CandidatoResponse>> getAllCandidatos() {
        return ResponseEntity.ok(candidatoService.getAllCandidatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatoResponse> getCandidatoById(@PathVariable Long id) {
        return ResponseEntity.ok(candidatoService.getCandidatoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidatoResponse> updateCandidato(@PathVariable Long id, @RequestBody CandidatoRequest candidatoRequest) {
        return ResponseEntity.ok(candidatoService.updateCandidato(id, candidatoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidato(@PathVariable Long id) {
        candidatoService.deleteCandidato(id);
        return ResponseEntity.ok().build();
    }
}

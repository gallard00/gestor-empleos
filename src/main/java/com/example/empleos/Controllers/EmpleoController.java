package com.example.empleos.Controllers;

    import com.example.empleos.Dtos.EmpleoRequest;
    import com.example.empleos.Dtos.EmpleoResponse;
    import com.example.empleos.Services.EmpleoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

@RestController
@RequestMapping("/empleos")
public class EmpleoController {
    @Autowired
    private EmpleoService empleoService;

    @PostMapping
    public ResponseEntity<EmpleoResponse> createEmpleo(@RequestBody EmpleoRequest empleoRequest) {
        EmpleoResponse empleoResponse = empleoService.createEmpleo(empleoRequest);
        return ResponseEntity.ok(empleoResponse);
    }

    @GetMapping
    public ResponseEntity<List<EmpleoResponse>> getAllEmpleos() {
        List<EmpleoResponse> empleos = empleoService.getAllEmpleos();
        return ResponseEntity.ok(empleos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleoResponse> getEmpleoById(@PathVariable Long id) {
        EmpleoResponse empleoResponse = empleoService.getEmpleoById(id);
        return ResponseEntity.ok(empleoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleoResponse> updateEmpleo(@PathVariable Long id, @RequestBody EmpleoRequest empleoRequest) {
        EmpleoResponse updatedEmpleo = empleoService.updateEmpleo(id, empleoRequest);
        return ResponseEntity.ok(updatedEmpleo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleo(@PathVariable Long id) {
        empleoService.deleteEmpleo(id);
        return ResponseEntity.ok().build();
    }
}

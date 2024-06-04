package com.example.empleos.Services;
    import com.example.empleos.Dtos.LigaRequest;
    import com.example.empleos.Dtos.LigaResponse;
    import com.example.empleos.Models.Liga;
    import com.example.empleos.Models.Partido;

    import java.util.List;
    import java.util.Optional;

public interface LigaService {
    LigaResponse createLiga(LigaRequest request);
    List<LigaResponse> getAllLigas();
    LigaResponse getLigaById(Long id);
    LigaResponse updateLiga(Long id, LigaRequest request);
    void deleteLiga(Long id);
    Optional<Liga> findLigaById(Long id);
}

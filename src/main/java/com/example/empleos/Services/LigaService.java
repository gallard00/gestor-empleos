package com.example.empleos.Services;
    import com.example.empleos.Dtos.LigaRequest;
    import com.example.empleos.Dtos.LigaResponse;
    import com.example.empleos.Models.Liga;
    import com.example.empleos.Models.Partido;

    import java.util.List;

public interface LigaService {
    LigaResponse createLiga(LigaRequest request);
    LigaResponse getLigaById(Long id);
    Liga getLigaEntityById(Long id);
    List<LigaResponse> getAllLigas();
    LigaResponse updateLiga(Long id, LigaRequest request);
    void deleteLiga(Long id);
}

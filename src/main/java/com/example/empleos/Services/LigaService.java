package com.example.empleos.Services;
    import com.example.empleos.Dtos.LigaRequest;
    import com.example.empleos.Dtos.LigaResponse;
    import com.example.empleos.Models.Liga;

    import java.util.List;

public interface LigaService {
    LigaResponse getLigaById(Long id);
    List<LigaResponse> getAllLigas();
    LigaResponse createLiga(LigaRequest ligaRequest);
    LigaResponse updateLiga(Long id, LigaRequest ligaRequest);
    void deleteLiga(Long id);
}

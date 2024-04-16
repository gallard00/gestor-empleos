package com.example.empleos.Services;

    import com.example.empleos.Dtos.CandidatoResponse;
    import com.example.empleos.Dtos.CandidatoRequest;

    import java.util.List;

public interface CandidatoService {
    CandidatoResponse saveCandidato(CandidatoRequest candidatoRequest);
    List<CandidatoResponse> getAllCandidatos();
    CandidatoResponse getCandidatoById(Long id);
    CandidatoResponse updateCandidato(Long id, CandidatoRequest candidatoRequest);
    String deleteCandidato(Long id);
}

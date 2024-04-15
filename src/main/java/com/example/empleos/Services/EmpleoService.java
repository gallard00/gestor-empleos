package com.example.empleos.Services;

    import com.example.empleos.Dtos.EmpleoResponse;
    import com.example.empleos.Dtos.EmpleoRequest;

    import java.util.List;

public interface EmpleoService {
    EmpleoResponse createEmpleo(EmpleoRequest empleoRequest);
    List<EmpleoResponse> getAllEmpleos();
    EmpleoResponse getEmpleoById(Long id);
    EmpleoResponse updateEmpleo(Long id, EmpleoRequest empleoRequest);
    void deleteEmpleo(Long id);

}

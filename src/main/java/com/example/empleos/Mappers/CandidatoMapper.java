package com.example.empleos.Mappers;

    import com.example.empleos.Dtos.CandidatoRequest;
    import com.example.empleos.Dtos.CandidatoResponse;
    import com.example.empleos.Models.Candidato;
    import org.springframework.stereotype.Component;

@Component
public class CandidatoMapper {
    public Candidato candidatoRequestToCandidato(CandidatoRequest request) {
        Candidato candidato = new Candidato();
        candidato.setNombre(request.getNombre());
        candidato.setEmail(request.getEmail());
        return candidato;
    }

    public CandidatoResponse candidatoToCandidatoResponse(Candidato candidato) {
        CandidatoResponse response = new CandidatoResponse();
        response.setId(candidato.getId());
        response.setNombre(candidato.getNombre());
        response.setEmail(candidato.getEmail());
        return response;
    }
}

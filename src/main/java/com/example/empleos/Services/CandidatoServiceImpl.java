package com.example.empleos.Services;

    import com.example.empleos.Dtos.CandidatoRequest;
    import com.example.empleos.Dtos.CandidatoResponse;
    import com.example.empleos.Mappers.CandidatoMapper;
    import com.example.empleos.Models.Candidato;
    import com.example.empleos.Repositories.CandidatoRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private CandidatoMapper candidatoMapper;

    @Override
    @Transactional
    public CandidatoResponse saveCandidato(CandidatoRequest candidatoRequest) {
        Candidato candidato = candidatoMapper.candidatoRequestToCandidato(candidatoRequest);
        return candidatoMapper.candidatoToCandidatoResponse(candidatoRepository.save(candidato));
    }

    @Override
    public List<CandidatoResponse> getAllCandidatos() {
        return candidatoRepository.findAll().stream()
                .map(candidatoMapper::candidatoToCandidatoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CandidatoResponse getCandidatoById(Long id) {
        Candidato candidato = candidatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidato no encontrado"));
        return candidatoMapper.candidatoToCandidatoResponse(candidato);
    }

    @Override
    @Transactional
    public CandidatoResponse updateCandidato(Long id, CandidatoRequest candidatoRequest) {
        Candidato candidato = candidatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidato no encontrado"));
        candidato.setNombre(candidatoRequest.getNombre());
        candidato.setEmail(candidatoRequest.getEmail());
        return candidatoMapper.candidatoToCandidatoResponse(candidatoRepository.save(candidato));
    }

    @Override
    public String deleteCandidato(Long id) {

        Candidato candidato = candidatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidato no encontrado"));

        candidatoRepository.delete(candidato);

        return "Candidato eliminado: ";
    }
}

package com.example.empleos.Services;

    import com.example.empleos.Repositories.EmpleoRepository;
    import com.example.empleos.Models.Empleo;
    import com.example.empleos.Dtos.EmpleoRequest;
    import com.example.empleos.Dtos.EmpleoResponse;
    import com.example.empleos.Mappers.EmpleoMapper;
    import com.example.empleos.Mappers.CandidatoMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

@Service
public class EmpleoServiceImpl implements EmpleoService {
    @Autowired
    private EmpleoRepository empleoRepository;

    @Autowired
    private CandidatoMapper candidatoMapper;

    @Override
    public EmpleoResponse createEmpleo(EmpleoRequest empleoRequest) {
        Empleo empleo = EmpleoMapper.empleoRequestToEmpleo(empleoRequest);
        empleo = empleoRepository.save(empleo);
        return EmpleoMapper.empleoToEmpleoResponse(empleo);
    }

    @Override
    public List<EmpleoResponse> getAllEmpleos() {
        List<Empleo> empleos = empleoRepository.findAll();
        return EmpleoMapper.empleosToEmpleoResponseList(empleos);
    }

    @Override
    public EmpleoResponse getEmpleoById(Long id) {
        Optional<Empleo> empleo = empleoRepository.findById(id);
        return empleo.map(EmpleoMapper::empleoToEmpleoResponse).orElse(null);
    }

    @Override
    public EmpleoResponse updateEmpleo(Long id, EmpleoRequest empleoRequest) {
        Optional<Empleo> existingEmpleo = empleoRepository.findById(id);
        if (existingEmpleo.isPresent()) {
            Empleo updatedEmpleo = existingEmpleo.get();
            updatedEmpleo.setTitulo(empleoRequest.getTitulo());
            updatedEmpleo.setDescripcion(empleoRequest.getDescripcion());
            updatedEmpleo.setSalario(empleoRequest.getSalario());
            updatedEmpleo.setDisponible(empleoRequest.isDisponible());
            empleoRepository.save(updatedEmpleo);
            return EmpleoMapper.empleoToEmpleoResponse(updatedEmpleo);
        }
        return null; // or throw an exception as per your error handling policy
    }

    @Override
    public void deleteEmpleo(Long id) {
        empleoRepository.deleteById(id);
    }

}

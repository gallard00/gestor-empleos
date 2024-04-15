package com.example.empleos.Mappers;

    import com.example.empleos.Models.Empleo;
    import com.example.empleos.Dtos.EmpleoResponse;
    import com.example.empleos.Dtos.EmpleoRequest;
    import java.util.List;
    import java.util.stream.Collectors;

public class EmpleoMapper {
    // Convierte EmpleoRequest a Empleo (para crear o actualizar empleos)
    public static Empleo empleoRequestToEmpleo(EmpleoRequest empleoRequest) {
        Empleo empleo = new Empleo();
        empleo.setTitulo(empleoRequest.getTitulo());
        empleo.setDescripcion(empleoRequest.getDescripcion());
        empleo.setSalario(empleoRequest.getSalario());
        empleo.setDisponible(empleoRequest.isDisponible());
        return empleo;
    }

    // Convierte Empleo a EmpleoResponse (para respuestas)
    public static EmpleoResponse empleoToEmpleoResponse(Empleo empleo) {
        EmpleoResponse empleoResponse = new EmpleoResponse();
        empleoResponse.setId(empleo.getId());
        empleoResponse.setTitulo(empleo.getTitulo());
        empleoResponse.setDescripcion(empleo.getDescripcion());
        empleoResponse.setSalario(empleo.getSalario());
        empleoResponse.setDisponible(empleo.isDisponible());
        return empleoResponse;
    }

    // Convierte una lista de Empleo a una lista de EmpleoResponse
    public static List<EmpleoResponse> empleosToEmpleoResponseList(List<Empleo> empleos) {
        return empleos.stream().map(EmpleoMapper::empleoToEmpleoResponse).collect(Collectors.toList());
    }
}

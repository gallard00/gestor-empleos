package com.example.empleos.Dtos;
    import lombok.Data;

    import java.util.Set;

@Data
public class EquipoResponse {
    private Long id;
    private String nombre;
    private LigaResponse liga;
    private Set<JugadorResponse> jugadores;
    private Set<PartidoResponse> partidosLocal;
    private Set<PartidoResponse> partidosVisitante;
}

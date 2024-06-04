package com.example.empleos.Dtos;
    import lombok.Builder;
    import lombok.Data;
    import java.util.List;

@Data
@Builder
public class EquipoResponse {
    private Long id;
    private String nombre;
    private LigaResponse liga;
    private List<JugadorResponse> jugadores;

}

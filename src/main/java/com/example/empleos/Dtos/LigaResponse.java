package com.example.empleos.Dtos;
    import lombok.Builder;
    import lombok.Data;
    import java.util.List;

@Data
@Builder
public class LigaResponse {
    private Long id;
    private String nombre;
    private List<EquipoResponse> equipos;
}

package com.example.empleos.Dtos;
    import lombok.Builder;
    import lombok.Data;

@Data
@Builder
public class JugadorResponse {
    private Long id;
    private String nombre;
    private EquipoResponse equipo;
}

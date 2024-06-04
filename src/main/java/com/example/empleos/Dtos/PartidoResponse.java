package com.example.empleos.Dtos;
    import lombok.Builder;
    import lombok.Data;
    import java.util.Date;

@Data
@Builder
public class PartidoResponse {
    private Long id;
    private Date fecha;
    private EquipoResponse equipoLocal;
    private EquipoResponse equipoVisitante;
}

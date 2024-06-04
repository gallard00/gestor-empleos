package com.example.empleos.Dtos;
    import lombok.Data;
    import java.util.Date;

@Data
public class PartidoResponse {
    private Long id;
    private EquipoResponse equipoLocal;
    private EquipoResponse equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private Date fecha;
    private LigaResponse liga;
}

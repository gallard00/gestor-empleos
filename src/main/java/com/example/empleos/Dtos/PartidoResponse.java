package com.example.empleos.Dtos;
    import lombok.Data;
    import java.util.Date;

@Data
public class PartidoResponse {
    private Long id;
    private Long equipoLocalId;
    private Long equipoVisitanteId;
    private int golesLocal;
    private int golesVisitante;
    private Date fecha;
    private Long ligaId;
}

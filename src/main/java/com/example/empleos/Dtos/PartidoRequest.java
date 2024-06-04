package com.example.empleos.Dtos;

    import lombok.Data;
    import java.util.Date;

@Data
public class PartidoRequest {

    private Date fecha;
    private Long equipoLocalId;
    private Long equipoVisitanteId;
}

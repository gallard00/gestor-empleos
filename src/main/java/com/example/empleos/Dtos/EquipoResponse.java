package com.example.empleos.Dtos;
    import lombok.Data;

    import java.util.Set;

@Data
public class EquipoResponse {
    private Long id;
    private String nombre;
    private int partidos;
    private int ganados;
    private int empatados;
    private int perdidos;
    private int golesFavor;
    private int golesContra;
    private int diferencia;
    private int puntos;
    private Set<LigaResponse> liga;
}

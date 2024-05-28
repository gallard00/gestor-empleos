package com.example.empleos.Dtos;
    import lombok.Data;

@Data
public class EquipoRequest {
    private String nombre;
    private int partidos;
    private int ganados;
    private int empatados;
    private int perdidos;
    private int golesFavor;
    private int golesContra;
    private int diferencia;
    private int puntos;
    private Long ligaId;
}

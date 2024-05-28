package com.example.empleos.Dtos;
    import lombok.Data;

@Data
public class JugadorRequest {
    private String nombre;
    private String apellido;
    private String posicion;
    private Long equipoId;
}
